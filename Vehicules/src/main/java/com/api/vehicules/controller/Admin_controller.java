package com.api.vehicules.controller;

import com.api.vehicules.config.token;
import com.api.vehicules.model.*;
import com.api.vehicules.service.Admin_service;
import com.api.vehicules.service.Token_service;
import com.api.vehicules.service.Utilisateur_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/authentication")
@CrossOrigin
public class Admin_controller {
    @Autowired
    Admin_service admin_service;
    private Token_service token_service;

    @GetMapping("all_admin")
    public List<Admin> getListAdmin(){

        return admin_service.getAllAdmin();
    }
    @PostMapping("/loginAdmin")
    public String loginUtilisateur(@RequestBody Authentification auth) {
        Admin login = admin_service.loginAdmin(auth.getEmail(),auth.getMdp());
        return token.generateTokenAdmin(login);
    }
    @GetMapping("/{id}")
    public Optional<Admin> getAdminById(@PathVariable int id) {
        return admin_service.getAdminById(id);
    }


    @PostMapping("/verifloginAdmin")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password){
        Response response = new Response();
        try{
            Admin admin = new Admin_service().loginAdmin(email,password);
            if(admin != null){
                Map<String, Object> map = new Admin_service().generateToken(admin);
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
