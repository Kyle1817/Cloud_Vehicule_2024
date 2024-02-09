package com.api.vehicules.controller;

import com.api.vehicules.model.Categorie;
import com.api.vehicules.service.Categorie_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categorie/")
@CrossOrigin
public class Categorie_controller {
    @Autowired
    Categorie_service categorie_service;

    @GetMapping("all_categorie")
    public List<Categorie> getListCategorie(){
        return categorie_service.getAllCategorie();
    }
    @PostMapping("/add_categorie")
    public ResponseEntity<Categorie> createCategorie(@RequestBody Categorie categorie){
        Categorie create_cat = categorie_service.createCategorie(categorie);
        return new ResponseEntity<>(create_cat, HttpStatus.CREATED);
    }
}
