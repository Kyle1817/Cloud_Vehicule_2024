package com.api.vehicules.repository;

import com.api.vehicules.model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Voiture_repository extends JpaRepository<Voiture, Integer> {
}
