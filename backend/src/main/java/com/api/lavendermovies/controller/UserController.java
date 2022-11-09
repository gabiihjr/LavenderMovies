package com.api.lavendermovies.controller;

import com.api.lavendermovies.domain.models.Role;
import com.api.lavendermovies.domain.models.User;
import com.api.lavendermovies.forms.UserForm;
import com.api.lavendermovies.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserController {
    private final IUserService userService;

    @PreAuthorize("permitAll()")
    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserForm userForm){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/users").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(userForm));
//        return status(HttpStatus.CREATED).body(userService.saveUser(userForm));
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/role")
    public ResponseEntity<Object> saveRole(@RequestBody @Valid Role roleForm){
        return status(HttpStatus.CREATED).body(userService.saveRole(roleForm));
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }
}
