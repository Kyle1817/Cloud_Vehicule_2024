package com.api.vehicules.repository;

import com.api.vehicules.model.Marque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Marque_repository extends JpaRepository<Marque, Integer> {
}
