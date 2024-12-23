package com.weblog.utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncryptor {

    public static String encrypt(String plainTextPswd) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(14);
        String encodedPswd = encoder.encode(plainTextPswd);
        return encodedPswd;
    }

    public static boolean verify(String plainPassword, String hashedPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(14);
        return encoder.matches(plainPassword, hashedPassword);
    }
}