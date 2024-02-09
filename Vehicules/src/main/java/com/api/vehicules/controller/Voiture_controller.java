package com.api.vehicules.controller;


import com.api.vehicules.model.Voiture;
import com.api.vehicules.service.Voiture_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/voiture/")
@CrossOrigin
public class Voiture_controller {
    @Autowired
    Voiture_service voiture_service;

    @GetMapping("all_voiture")
    public List<Voiture> getListVoiture(){
        return voiture_service.getAllVoiture();
    }

    @PostMapping("/add_voiture")
    public ResponseEntity<Voiture> createVoiture(@RequestBody Voiture voiture){
        Voiture create_voiture = voiture_service.createVoiture(voiture);
        return new ResponseEntity<>(create_voiture, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Optional<Voiture> getAnnonceById(@PathVariable int id) {
        return voiture_service.getVoitureby(id);
    }
}
