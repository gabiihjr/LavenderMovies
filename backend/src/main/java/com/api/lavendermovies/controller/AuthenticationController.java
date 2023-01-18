package com.api.lavendermovies.controller;

import com.api.lavendermovies.config.security.JwtUtils;
import com.api.lavendermovies.dao.UserDao;
import com.api.lavendermovies.dtos.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    private final UserDao userDao;
    private final JwtUtils jwtUtils;

//    @PreAuthorize("permitAll()")
    @PostMapping
    public ResponseEntity<String> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        final UserDetails user = userDao.findUserByEmail(request.getEmail());
        if (user != null) {
            return ResponseEntity.ok(jwtUtils.generateToken(user));
        }
        return ResponseEntity.status(400).body("Some error has occurred");
    }
}
