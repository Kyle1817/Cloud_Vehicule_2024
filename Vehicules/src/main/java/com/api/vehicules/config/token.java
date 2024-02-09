package com.api.vehicules.config;

import com.api.vehicules.model.Admin;
import com.api.vehicules.model.Utilisateur;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class token {
    private static final String secret = "DvxMWzlQ2d6zSQ77EseNcGI1x0hhpCVJwtXBIx4c7uUlDSSRCD4kBXFyzEY2zLdN";
    private static final Key key = new SecretKeySpec(Base64.getDecoder().decode(secret),
            SignatureAlgorithm.HS256.getJcaName());

    public static String generateToken(Utilisateur utilisateur) {
        System.out.println(utilisateur.getEmail());
        Date currentDate = new Date();

        String token = Jwts.builder()
                .setSubject(utilisateur.getEmail())
                .setIssuedAt(currentDate)
                .setExpiration(new Date(currentDate.getTime() + dayToMs(1)))
                .signWith(key)
                .compact();

        return token;
    }
    public static String generateTokenAdmin(Admin admin) {
        System.out.println(admin.getEmail());
        Date currentDate = new Date();

        String token = Jwts.builder()
                .setSubject(admin.getEmail())
                .setIssuedAt(currentDate)
                .setExpiration(new Date(currentDate.getTime() + dayToMs(1)))
                .signWith(key)
                .compact();

        return token;
    }

    public String getUsername(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public void validateToken(String token) throws AuthenticationCredentialsNotFoundException {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
        } catch (Exception ex) {
            throw new AuthenticationCredentialsNotFoundException("Invalid token",
                    ex.fillInStackTrace());
        }
    }

    private static long dayToMs(int days) {
        return days * 24 * 60 * 60 * 1000L;
    }
}
