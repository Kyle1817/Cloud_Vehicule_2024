package com.api.vehicules.controller;

import com.api.vehicules.model.Ville;
import com.api.vehicules.service.Ville_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authentication")
public class Ville_Controller {
    @Autowired
    Ville_service ville_service;

    @GetMapping("all_ville")
    public List<Ville> getListVille(){
        return ville_service.getAllVille();
    }
    @PostMapping("/add_ville")
    public ResponseEntity<Ville> createVille(@RequestBody Ville ville)
    {
        Ville create_ville = ville_service.createVille(ville);
        return new ResponseEntity<>(create_ville, HttpStatus.CREATED);
    }
}
