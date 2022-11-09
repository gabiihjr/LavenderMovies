package com.api.lavendermovies.service;

import com.api.lavendermovies.config.ObjectMapper;
import com.api.lavendermovies.config.exceptions.BusinessException;
import com.api.lavendermovies.domain.models.Role;
import com.api.lavendermovies.domain.models.User;
import com.api.lavendermovies.enums.RoleName;
import com.api.lavendermovies.forms.UserForm;
import com.api.lavendermovies.repository.RoleRepository;
import com.api.lavendermovies.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User saveUser(UserForm userForm) {
        boolean usernameExists = userRepository.findByUsername(userForm.getUsername()).isPresent();
        if (usernameExists) throw new BusinessException("Username is already in use.");

        User user = ObjectMapper.map(userForm, User.class);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        addRoleToUser(user.getUsername(), RoleName.ADMIN);

        return userRepository.save(user);
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Role saveRole(Role role) {
        boolean roleExists = roleRepository.findByRoleName(role.getRoleName()).isPresent();
        if (roleExists) throw new BusinessException("Role already exists.");

        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, RoleName roleName) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Role role = roleRepository.findByRoleName(roleName)
                .orElseThrow(() -> new BusinessException("Role not found"));

        user.getRoles().add(role);
    }
}
