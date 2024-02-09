package com.api.vehicules.service;

import com.api.vehicules.model.Utilisateur;
import com.api.vehicules.repository.Utilisateur_repository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.api.vehicules.service.Authentification_service.generateSecretKey;

@Service
public class Utilisateur_service {
    @Autowired
    private Utilisateur_repository utilisateur_repository;

    public Utilisateur createUtilisateur(Utilisateur utilisateur){
        Utilisateur createUser = utilisateur_repository.save(utilisateur);
        return createUser;
    }
    public Optional<Utilisateur> getUtilisateurbyId(int id){
        return utilisateur_repository.findById(id);
    }
    public Utilisateur updateUtilisateur(Utilisateur utilisateur){
        return utilisateur_repository.save(utilisateur);
    }
    public void deleteUtilisateur(int id){
        utilisateur_repository.deleteById(id);
    }

    public Utilisateur loginUtilisateur(String email, String mdp){
        List<Utilisateur> source = utilisateur_repository.findAll();
        Utilisateur valiny = new Utilisateur();
        for(int i = 0; i<source.size(); i++){
            if(source.get(i).getEmail().equals(email) && source.get(i).getMdp().equals(mdp)){
                valiny = source.get(i);
            }
        }
        return valiny;
    }
    public Optional<Utilisateur> getUtilisateurby(int id){
        return utilisateur_repository.findById(id);
    }

    public Map<String, Object> generateToken(Utilisateur utilisateur)
    {
        Date now = new Date();
        long jwtExpiratioinInMs = TimeUnit.MINUTES.toMillis(120);
        Date expiryDate = new Date(now.getTime() + jwtExpiratioinInMs);
        String cle = generateSecretKey();
        Claims claims = Jwts.claims().setSubject(Long.toString(utilisateur.getId_utilisateur()));
        claims.put("id_user",utilisateur.getId_utilisateur());
        String token = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512,cle)
                .compact();
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("cle",cle);
        response.put("date",now);
        response.put("expirer",expiryDate);
        return response;
    }

    public Optional<Utilisateur> findByUserName(String username) {
        return utilisateur_repository.findByUsername(username);
    }

}
