package com.tbawor.agro.security.config;

import static com.tbawor.agro.security.config.SecurityConstants.EXPIRATION_TIME;
import static com.tbawor.agro.security.config.SecurityConstants.HEADER_STRING;
import static com.tbawor.agro.security.config.SecurityConstants.LOGIN_URL;
import static com.tbawor.agro.security.config.SecurityConstants.SECRET;
import static com.tbawor.agro.security.config.SecurityConstants.TOKEN_PREFIX;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tbawor.agro.security.ui.LoginUserDto;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
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

    private final AuthenticationManager authenticationManager;

    @Autowired
    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setRequiresAuthenticationRequestMatcher(
                new AntPathRequestMatcher(LOGIN_URL, "POST")
        );
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            LoginUserDto credentials = new ObjectMapper()
                    .readValue(req.getInputStream(), LoginUserDto.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            credentials.getLogin(),
                            credentials.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        String token = Jwts.builder()
                .setSubject(((ApplicationUserDetails) auth.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes(Charset.forName("UTF-8")))
                .compact();
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    }
}
