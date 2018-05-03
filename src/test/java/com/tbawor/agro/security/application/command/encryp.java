package com.tbawor.agro.security.application.command;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class encryp {

    @Test
    public void test() {
        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
        final String admin = enc.encode("user");
        System.out.println(admin);
    }
}
