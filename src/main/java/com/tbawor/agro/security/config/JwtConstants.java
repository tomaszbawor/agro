package com.tbawor.agro.security.config;

class JwtConstants {

    private JwtConstants() {
        // prevent creating instance
    }

    static final String TOKEN_PREFIX = "Bearer ";
    static final String HEADER_STRING = "Authorization";
    static final String SECRET = "SecretKeyToGenJWTs";

}
