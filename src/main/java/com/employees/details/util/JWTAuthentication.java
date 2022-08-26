package com.employees.details.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class JWTAuthentication {

    @Value("${jwt.secret.key}")
    private String secretKet;

    @Value("${jwt.expiry}")
    private int expiry;

    @Value("${jwt.token.path}")
    private String tokenPath;

    public String getTokenPath() {
        return tokenPath;
    }

    public void setTokenPath(String tokenPath) {
        this.tokenPath = tokenPath;
    }

    public String getToken() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("Key1", "Value1");
        claims.put("Key2", "Value2");
        System.out.println(secretKet);
            return Jwts.builder()
                    .setIssuer("EmployeeApplication")
                    .setSubject("EmployeeApplicationAuthentication")
                    .setClaims(claims)
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + expiry))
                    .signWith(SignatureAlgorithm.HS256, secretKet)
                    .compact();
    }

    public boolean authenticate(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(secretKet)
                    .parseClaimsJws(token);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
