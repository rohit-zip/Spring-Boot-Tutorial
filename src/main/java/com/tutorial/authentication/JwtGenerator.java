package com.tutorial.authentication;

import com.tutorial.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.authentication
 * Created_on - 20 January-2024
 * Created_at - 21 : 22
 */

public class JwtGenerator {

    private static final String SECRET_KEY = "7856856745847347457347357837458457357374578457";

    public String generateToken(User user) {
        Map<String, String> emailMap = new HashMap<>();
        emailMap.put("email", user.getEmail());
        return Jwts
                .builder()
                .setSubject(String.valueOf(user.getUserId()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() * 1000 * 60))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .setClaims(emailMap)
                .compact();
    }

    private Key getSigningKey() {
        byte[] decode = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(decode);
    }
}
