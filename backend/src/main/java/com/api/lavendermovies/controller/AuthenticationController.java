package com.api.lavendermovies.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/authenticate")
public class AuthenticationController {
    private AuthenticationManager authenticationManager;

//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
//    @PostMapping
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequestForm authenticationRequest)
//        throws Exception {
//        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//
//        final UserDetails userDetails = userDetailsService
//                .loadUserByUsername(authenticationRequest.getUsername());
//
//        final String token = jwtTokenUtil.generateToken(userDetails);
//
//        return ResponseEntity.ok(new JwtResponse(token));
//    }
//
//    private void authenticate(String username, String password) throws Exception {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        } catch (DisabledException e) {
//            throw new Exception("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
//    }
}
