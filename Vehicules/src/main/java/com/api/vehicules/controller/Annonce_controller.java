package com.api.vehicules.controller;

import com.api.vehicules.model.Annonce;
import com.api.vehicules.service.Annonce_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/annonce/")
@CrossOrigin
public class Annonce_controller {
    @Autowired
    Annonce_service annonce_service;

    @GetMapping("all_annonce")
    public List<Annonce> getListAnnonce(){
        return annonce_service.getAllAnnonce();
    }
    
    @PostMapping("/add_annonce")
    public ResponseEntity<Annonce> createAnnonce(@RequestBody Annonce annonce){
        Annonce create_annonce = annonce_service.createAnnonce(annonce);
        return new ResponseEntity<>(create_annonce, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public Optional<Annonce> getAnnonceById(@PathVariable int id) {
        return annonce_service.getAnnonceById(id);
    }

    @PutMapping("/update_annonce")
    public Annonce updateAnnonce(@RequestBody Annonce annonce) {
        return annonce_service.updateAnnonce(annonce);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnnonce(@PathVariable int id) {
        annonce_service.deleteAnnonce(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/accepte_annonce/{accepte_annonce}")
    public List<Annonce> findByAccept_annonce(@PathVariable int accepte_annonce){
        return annonce_service.GetAnnoncebyAccept_annonce(accepte_annonce);
    }

}
