package com.api.vehicules.controller;

import com.api.vehicules.model.Interaction;
import com.api.vehicules.service.Interaction_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/interaction/")
@CrossOrigin
public class Interaction_controller {
    @Autowired
    Interaction_service interaction_service;

    @GetMapping("all_interaction")
    public List<Interaction> getListInteraction(){
        return interaction_service.getAllInteraction();
    }
    @PostMapping("/add_interaction")
    public ResponseEntity<Interaction> createInteraction(@RequestBody Interaction interaction){
        Interaction create_interact = interaction_service.createInteraction(interaction);
        return new ResponseEntity<>(create_interact, HttpStatus.CREATED);
    }
}
