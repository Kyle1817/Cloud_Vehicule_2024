package com.api.vehicules.controller;

import com.api.vehicules.model.Entretien;
import com.api.vehicules.service.Entretien_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/entretien/")
@CrossOrigin
public class Entretien_controller {
    @Autowired
    Entretien_service entretien_service;

    @GetMapping("all_entretien")
    public List<Entretien> getAllEntretien(){
        return entretien_service.getAllEntretien();
    }
    @PostMapping("/add_entretien")
    public ResponseEntity<Entretien> createEntretien(@RequestBody Entretien entretien){
        Entretien create_entretien = entretien_service.createEntretien(entretien);
        return new ResponseEntity<>(create_entretien, HttpStatus.CREATED);
    }
}
