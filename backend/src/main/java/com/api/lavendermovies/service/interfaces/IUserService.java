package com.api.lavendermovies.service.interfaces;

import com.api.lavendermovies.domain.models.Role;
import com.api.lavendermovies.domain.models.User;
import com.api.lavendermovies.dtos.GetUserDto;
import com.api.lavendermovies.enums.RoleName;
import com.api.lavendermovies.forms.UserForm;

import java.util.List;


public interface IUserService {
    User saveUser(UserForm user);
    User getUser(String username);
    List<GetUserDto> getUsers();
    Role saveRole(Role role);
    void addRoleToUser(String username, RoleName roleName);
}
