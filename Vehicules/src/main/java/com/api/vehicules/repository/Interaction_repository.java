package com.api.vehicules.repository;

import com.api.vehicules.model.Interaction;
import com.api.vehicules.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Interaction_repository extends JpaRepository<Interaction, Integer> {

}
