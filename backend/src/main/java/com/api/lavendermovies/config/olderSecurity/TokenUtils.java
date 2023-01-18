//package com.api.lavendermovies.config.security;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.JwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.stereotype.Component;
//
//import java.util.Collections;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class TokenUtils {
//
//    private final static String ACCESS_TOKEN_SECRET = "8y/B?E(H+KbPeShVmYq3t6w9z$C&F)J@";
//    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;
//
//
//    public static String createToken(String name, String username) {
//        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
//        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
//
//        Map<String, Object> extra = new HashMap<>();
//        extra.put("name", name);
//
//        return Jwts.builder()
//                .setSubject(username)
//                .setExpiration(expirationDate)
//                .addClaims(extra)
//                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
//                .compact();
//    }
//
//    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
//        try {
//            Claims claims = Jwts.parserBuilder()
//                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
//                    .build()
//                    .parseClaimsJws(token)
//                    .getBody();
//
//            String username = claims.getSubject();
//
//            return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
//        } catch (JwtException e) {
//            return null;
//        }
//    }
//}
