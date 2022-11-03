package com.api.lavendermovies.controller;

import com.api.lavendermovies.forms.UserForm;
import com.api.lavendermovies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.status;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PreAuthorize("permitAll()")
    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserForm userForm){
        return status(HttpStatus.CREATED).body(userService.save(userForm));
    }
}
