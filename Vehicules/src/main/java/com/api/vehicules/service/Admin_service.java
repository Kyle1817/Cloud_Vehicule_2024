package com.api.vehicules.service;

import com.api.vehicules.model.Admin;
import com.api.vehicules.model.Annonce;
import com.api.vehicules.model.Categorie;
import com.api.vehicules.model.Utilisateur;
import com.api.vehicules.repository.Admin_repository;
import com.api.vehicules.repository.Categorie_repository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.api.vehicules.service.Authentification_service.generateSecretKey;

@Service
public class Admin_service {
    @Autowired
    private Admin_repository admin_repository;

    public List<Admin> getAllAdmin(){
        return admin_repository.findAll();
    }
    public Admin createAdmin(Admin admin) {
        Admin create_admin = admin_repository.save(admin);
        return create_admin;
    }
    public Optional<Admin> getAdminById(int id){
        return admin_repository.findById(id);
    }

    public Admin loginAdmin(String email, String mdp){
        List<Admin> source = admin_repository.findAll();
        Admin valiny = new Admin();
        for(int i = 0; i<source.size(); i++){
            if(source.get(i).getEmail().equals(email) && source.get(i).getMdp().equals(mdp)){
                valiny = source.get(i);
            }
        }
        return valiny;
    }

    public Map<String, Object> generateToken(Admin admin) {
        Date now = new Date();
        long jwtExpiratioinInMs = TimeUnit.MINUTES.toMillis(120);
        Date expiryDate = new Date(now.getTime() + jwtExpiratioinInMs);
        String cle = generateSecretKey();
        Claims claims = Jwts.claims().setSubject(Long.toString(admin.getId_admin()));
        claims.put("id_admin",admin.getId_admin());
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
    public Optional<Admin> findByAdmin(String username) {
        return admin_repository.getAdminById(username);
    }
}
