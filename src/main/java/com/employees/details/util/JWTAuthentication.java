package com.employees.details.util;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Controller;

@Controller
public class JWTAuthentication {

    public boolean authenticate(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(System.getenv("jwt_secret_key"))
                    .parseClaimsJws(token);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
