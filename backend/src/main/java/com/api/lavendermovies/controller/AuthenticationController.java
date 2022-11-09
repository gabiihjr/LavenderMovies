package com.api.lavendermovies.controller;

import com.api.lavendermovies.config.security.AuthCredentials;
import com.api.lavendermovies.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/authenticate")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PreAuthorize("permitAll()")
    @PostMapping
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthCredentials authenticationRequest)
        throws Exception {
        return ResponseEntity.ok(authenticationService.createAuthenticationToken(authenticationRequest));
    }
}
