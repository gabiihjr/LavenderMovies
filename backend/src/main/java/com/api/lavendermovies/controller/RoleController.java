package com.api.lavendermovies.controller;

import com.api.lavendermovies.forms.RoleForm;
import com.api.lavendermovies.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.status;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @PreAuthorize("permitAll()")
    @PostMapping
    public ResponseEntity<Object> saveRole(@RequestBody @Valid RoleForm roleForm){
        return status(HttpStatus.CREATED).body(roleService.save(roleForm));
    }

}
