package com.api.lavendermovies.service;

import com.api.lavendermovies.domain.models.Role;
import com.api.lavendermovies.domain.models.User;
import com.api.lavendermovies.enums.RoleName;
import com.api.lavendermovies.forms.UserForm;

import java.util.List;


public interface IUserService {
    User saveUser(UserForm user);
    User getUser(String username);
    List<User> getUsers();
    Role saveRole(Role role);
    void addRoleToUser(String username, RoleName roleName);
}
