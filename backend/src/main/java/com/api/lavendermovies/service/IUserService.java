package com.api.lavendermovies.service;

import com.api.lavendermovies.domain.models.Role;
import com.api.lavendermovies.domain.models.User;
import com.api.lavendermovies.enums.RoleName;

import java.util.List;


public interface IUserService {

//    public GetUserDto saveUser(UserForm userForm) {
//        var password = WebSecurityConfig.passwordEncoder().encode(userForm.getPassword());
//        userForm.setPassword(password);
//
//        var user = ObjectMapper.map(userForm, User.class);
//        var role = roleRepository.findByRoleName(RoleName.ADMIN)
//                .orElseThrow(() -> new BusinessException("Role not found."));
//
//        var roleList = new ArrayList<Role>();
//        roleList.add(role);
//
//        user.setRoles(roleList);
//
//        userRepository.save(user);
//
//        return ObjectMapper.map(userForm, GetUserDto.class);
//    }
//
//    public Role saveRole(RoleForm roleForm) {
//        var role = ObjectMapper.map(roleForm, Role.class);
//        return roleRepository.save(role);
//    }

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, RoleName roleName);

    User getUser(String username);

    List<User> getUsers();
}
