package com.api.vehicules.repository;

import com.api.vehicules.model.Entretien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Entretien_repository extends JpaRepository<Entretien, Integer> {
}
