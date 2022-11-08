package com.api.lavendermovies.filter;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//    private final AuthenticationManager authenticationManager;
//
//    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
//            throws AuthenticationException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
//                password);
//        return authenticationManager.authenticate(authenticationToken);
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request,
//                                            HttpServletResponse response,
//                                            FilterChain chain,
//                                            Authentication authentication) throws IOException, ServletException {
//        User user = (User) authentication.getPrincipal();
//        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
//        String access_token = JWT.create()
//                .withSubject(user.getUsername())
//                .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
//                .withIssuer(request.getRequestURL().toString())
//                .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority)
//                        .collect(Collectors.toList()))
//                .sign(algorithm);
//
//        String refresh_token = JWT.create()
//                .withSubject(user.getUsername())
//                .withExpiresAt(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
//                .withIssuer(request.getRequestURL().toString())
//                .sign(algorithm);
//
//        response.setHeader("access_token", access_token);
//        response.setHeader("refresh_token", refresh_token);
//    }
}