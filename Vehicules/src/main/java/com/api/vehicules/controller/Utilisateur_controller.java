package com.api.vehicules.controller;

import com.api.vehicules.config.token;
import com.api.vehicules.model.*;
import com.api.vehicules.service.Token_service;
import com.api.vehicules.service.Utilisateur_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/authentication")
public class Utilisateur_controller {
    @Autowired
    private Utilisateur_service utilisateur_service;
    private Token_service token_service;

    @PostMapping("/add_user")
    public ResponseEntity<Utilisateur> createUser(@RequestBody Utilisateur utilisateur){
        Utilisateur create_user = utilisateur_service.createUtilisateur(utilisateur);
        return new ResponseEntity<>(create_user, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public String loginUtilisateur(@RequestBody Authentification auth)
    {
        Utilisateur login = utilisateur_service.loginUtilisateur(auth.getEmail(),auth.getMdp());
        return token.generateToken(login);
    }

    @PutMapping("/update_utilisateur")
    public Utilisateur updateUtilisateur(@RequestBody Utilisateur user) {
        return utilisateur_service.updateUtilisateur(user);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable int id) {
        utilisateur_service.deleteUtilisateur(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/id_utilisateur/{id}")
    public Optional<Utilisateur> getUtilisateurById(@PathVariable int id) {
        return utilisateur_service.getUtilisateurby(id);
    }
    @PostMapping("/verifloginvendeur")
    public ResponseEntity<?> login(@RequestParam String email,@RequestParam String password){
        Response response = new Response();
        try{
            Utilisateur user = new Utilisateur_service().loginUtilisateur(email,password);
            if(user != null){
                Map<String, Object> map = new Utilisateur_service().generateToken(user);
                Token token = new Token();
                token.setCle((String)map.get("cle"));
                token.setToken((String)map.get("token"));
                token.setDatecreation(new Date(((java.util.Date)map.get("date")).getTime()));
                token.setDate_expiration(new Date(((java.util.Date)map.get("expirer")).getTime()));
                token_service.insert(token);

                response.setData(token.getToken());
                response.setStatus(HttpStatus.OK);
                response.setStatus_code("200");
                response.setMessage("");
            }
            else{
                response.setStatus_code("400");
                response.setMessage("Erreur login ou de password");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error during login: " + e.getMessage());

        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
