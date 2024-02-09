package com.api.vehicules.repository;

import com.api.vehicules.model.Categorie;
import com.api.vehicules.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Categorie_repository extends JpaRepository<Categorie, Integer> {
}
