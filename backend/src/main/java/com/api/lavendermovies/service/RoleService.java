package com.api.lavendermovies.service;

import com.api.lavendermovies.domain.models.Role;
import com.api.lavendermovies.forms.RoleForm;
import com.api.lavendermovies.repository.RoleRepository;
import com.api.lavendermovies.config.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public Role save(RoleForm roleForm) {
        var role = ObjectMapper.map(roleForm, Role.class);
        return roleRepository.save(role);
    }
}
