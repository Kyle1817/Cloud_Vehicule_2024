package com.api.vehicules.controller;

import com.api.vehicules.model.Marque;
import com.api.vehicules.service.Marque_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/marque/")
@CrossOrigin
public class Marque_controller {
    @Autowired
    Marque_service marque_service;

    @GetMapping("all_marque")
    public List<Marque> getListMarque()
    {
        return marque_service.getAllMarque();
    }

    @PostMapping("/add_marque")
    public ResponseEntity<Marque> createMarque(@RequestBody Marque marque){
        Marque create_marque = marque_service.createMarque(marque);
        return new ResponseEntity<>(create_marque, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public Optional<Marque> getMarqueById(@PathVariable int id) {
        return marque_service.getMarqueby(id);
    }
}