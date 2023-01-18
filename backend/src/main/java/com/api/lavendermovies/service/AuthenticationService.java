//package com.api.lavendermovies.service;
//
//import com.api.lavendermovies.config.security.AuthCredentials;
//import com.api.lavendermovies.config.security.TokenUtils;
//import com.api.lavendermovies.config.security.UserDetailsImpl;
//import com.api.lavendermovies.config.security.UserDetailsServiceImpl;
//import com.api.lavendermovies.dtos.JwtResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthenticationService {
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//    @Autowired
//    private TokenUtils tokenUtils;
//
//    public JwtResponse createAuthenticationToken(AuthCredentials authenticationRequest)
//            throws Exception {
//        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//
//        final UserDetailsImpl userDetails = (UserDetailsImpl)
//                userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//
//        final String token = TokenUtils.createToken(userDetails.getName(), userDetails.getUsername());
//
//        return new JwtResponse(token);
//    }
//
//    public void authenticate(String username, String password) throws Exception {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        } catch (DisabledException e) {
//            throw new Exception("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//            throw new Exception("INVALID_CREDENTIALS", e);
//        }
//    }
//}
