package com.api.vehicules.repository;

import com.api.vehicules.model.Detail;
import com.api.vehicules.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Detail_repository extends JpaRepository<Detail, Integer> {
}
