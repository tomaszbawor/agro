package com.tbawor.agro.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tbawor.agro.security.ui.LoginUserDto;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final String TOKEN_PREFIX = "Bearer ";
    private static final String HEADER_STRING = "Authorization";
    private static final String LOGIN_URL = "/api/users/login";
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days
    //TODO: Externalize this to properties
    private static final String SECRET = "SecretKeyToGenJWTs";


    private final AuthenticationManager authenticationManager;

    @Autowired
    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setRequiresAuthenticationRequestMatcher(
                new AntPathRequestMatcher(LOGIN_URL, "POST")
        );
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest req,
            HttpServletResponse res
    ) {
        try {
            LoginUserDto credentials = new ObjectMapper()
                    .readValue(req.getInputStream(), LoginUserDto.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            credentials.getLogin(),
                            credentials.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException exception) {
            throw new TokenParseException("Unable to parse token", exception);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) {

        String token = Jwts.builder()
                .setSubject(((ApplicationUserDetails) auth.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes(Charset.forName("UTF-8")))
                .compact();
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    }

    static class TokenParseException extends AuthenticationException {
        TokenParseException(String msg, Throwable t) {
            super(msg, t);
        }
    }
}
