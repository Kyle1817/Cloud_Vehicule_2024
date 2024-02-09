package com.api.vehicules.service;

import com.api.vehicules.model.Interaction;
import com.api.vehicules.repository.Interaction_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Interaction_service {
    @Autowired
    private Interaction_repository interaction_repository;

    public List<Interaction> getAllInteraction(){
        return interaction_repository.findAll();
    }
    public Interaction createInteraction(Interaction interaction)
    {
        Interaction createInter = interaction_repository.save(interaction);
        return createInter;
    }
}
