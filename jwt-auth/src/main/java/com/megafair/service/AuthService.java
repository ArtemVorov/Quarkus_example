package com.megafair.service;

import io.smallrye.jwt.build.Jwt;
import jakarta.inject.Singleton;

import java.util.HashSet;
import java.util.Set;

@Singleton
public class AuthService {

    public String generateJwt() {
        Set<String> roles = new HashSet<>();
        roles.add("platform");

        long duration = 3600;
        return Jwt.issuer("Megafair-jwt")
                .subject("Megafair-jwt") //todo Can contains platform specific infos (name etc.)
                .groups(roles)
                .expiresAt(System.currentTimeMillis() / 1000 + duration)
                .sign();
    }
}
