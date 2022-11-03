package com.api.lavendermovies.service;

import com.api.lavendermovies.config.exceptions.BusinessException;
import com.api.lavendermovies.config.security.WebSecurityConfig;
import com.api.lavendermovies.domain.models.Role;
import com.api.lavendermovies.domain.models.User;
import com.api.lavendermovies.dtos.GetUserDto;
import com.api.lavendermovies.enums.RoleName;
import com.api.lavendermovies.forms.UserForm;
import com.api.lavendermovies.repository.RoleRepository;
import com.api.lavendermovies.repository.UserRepository;
import com.api.lavendermovies.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public GetUserDto save(UserForm userForm) {
        var password = WebSecurityConfig.passwordEncoder().encode(userForm.getPassword());
        userForm.setPassword(password);

        var user = ObjectMapper.map(userForm, User.class);
        var role = roleRepository.findByRoleName(RoleName.ADMIN)
                .orElseThrow(() -> new BusinessException("Role not found."));

        var roleList = new ArrayList<Role>();
        roleList.add(role);

        user.setRoles(roleList);

        userRepository.save(user);

        return ObjectMapper.map(userForm, GetUserDto.class);
    }
}
