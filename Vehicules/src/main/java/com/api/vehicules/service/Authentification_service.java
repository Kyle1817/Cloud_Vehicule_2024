package com.api.vehicules.service;

import com.api.vehicules.model.Token;
import com.api.vehicules.repository.Token_repository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

public class Authentification_service {
    private Token_repository token_repository;
    public static Claims extractClaims(Token token){
        return (Claims) Jwts.parser().setSigningKey(token.getCle()).parseClaimsJws(token.getToken());
    }
    static String generateSecretKey(){
        byte[] keyBytes = Keys.secretKeyFor(SignatureAlgorithm.HS512).getEncoded();
        return Base64.getEncoder().encodeToString(keyBytes);
    }
    public void verifAutorisation(String token){
        Token tk = this.getByToken(token);
    }
    public Token getByToken(String token){
        Token tok = new Token();
        List<Token> list = token_repository.findAll();
        for(int i = 0; i<list.size(); i++)
        {
            if(tok.getToken().equals(token)){
                tok = list.get(i);
            }
        }
        return tok;
    }

}
