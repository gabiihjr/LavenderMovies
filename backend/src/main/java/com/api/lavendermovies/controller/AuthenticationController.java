package com.api.lavendermovies.controller;

import com.api.lavendermovies.config.security.JwtUtils;
import com.api.lavendermovies.dtos.AuthenticationRequest;
import com.api.lavendermovies.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/authenticate")
@RequiredArgsConstructor
public class AuthenticationController {
//    @Autowired
//    private AuthenticationService authenticationService;
//
//    @PreAuthorize("permitAll()")
//    @PostMapping
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthCredentials authenticationRequest)
//        throws Exception {
//        return ResponseEntity.ok(authenticationService.createAuthenticationToken(authenticationRequest));
//    }

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;

    @PreAuthorize("permitAll()")
    @PostMapping
    public ResponseEntity<String> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        final UserDetails user = userRepository.findByUsername(request.getUsername()).orElseThrow();
        if (user != null) {
            return ResponseEntity.ok(jwtUtils.generateToken(user));
        }
        return ResponseEntity.status(400).body("Some error has occurred");
    }
}
