package com.api.lavendermovies.controller;

import com.api.lavendermovies.domain.models.Role;
import com.api.lavendermovies.dtos.GetUserDto;
import com.api.lavendermovies.forms.UserForm;
import com.api.lavendermovies.service.interfaces.IUserService;
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

    @PostMapping("/signup")
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserForm userForm){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(userForm));
//        return status(HttpStatus.CREATED).body(userService.saveUser(userForm));
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/role")
    public ResponseEntity<Object> saveRole(@RequestBody @Valid Role roleForm){
        return status(HttpStatus.CREATED).body(userService.saveRole(roleForm));
    }

    @PreAuthorize("permitAll()")
    @GetMapping
    public ResponseEntity<List<GetUserDto>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }
}
