package com.api.vehicules.service;

import com.api.vehicules.model.Ville;
import com.api.vehicules.model.Voiture;
import com.api.vehicules.repository.Ville_repository;
import com.api.vehicules.repository.Voiture_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ville_service {
    @Autowired
    private Ville_repository ville_repository;

    public List<Ville> getAllVille(){
        return ville_repository.findAll();
    }
    public Ville createVille(Ville ville)
    {
        Ville createV = ville_repository.save(ville);
        return createV;
    }
}
