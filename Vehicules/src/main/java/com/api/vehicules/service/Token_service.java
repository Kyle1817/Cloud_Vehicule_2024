package com.api.vehicules.service;

import com.api.vehicules.model.Message;
import com.api.vehicules.model.Token;
import com.api.vehicules.repository.MessageRepository;
import com.api.vehicules.repository.Token_repository;
import io.jsonwebtoken.Claims;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Token_service {
    @Autowired
    private Token_repository token_repository;
    private Authentification_service authentification_service;

    public List<Token> getToken(){
        return token_repository.findAll();
    }

    public Token insert(Token token){
        Token createToken = token_repository.save(token);
        return createToken;
    }

}
