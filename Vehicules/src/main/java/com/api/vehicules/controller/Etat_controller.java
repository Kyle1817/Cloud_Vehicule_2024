package com.api.vehicules.controller;

import com.api.vehicules.model.Etat;
import com.api.vehicules.service.Etat_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/etat/")
@CrossOrigin
public class Etat_controller {
    @Autowired
    Etat_service etat_service;

    @GetMapping("all_etat")
    public List<Etat> getListEtat(){
        return etat_service.getAllEtat();
    }
    @PostMapping("/add_etat")
    public ResponseEntity<Etat> createEtat(@RequestBody Etat etat){
        Etat create_etat = etat_service.createEtat(etat);
        return new ResponseEntity<>(create_etat, HttpStatus.CREATED);
    }
}
