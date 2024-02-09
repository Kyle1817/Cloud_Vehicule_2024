package com.api.vehicules.repository;

import com.api.vehicules.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Utilisateur_repository extends JpaRepository<Utilisateur, Integer> {

    @Query(value = """
        SELECT 
        u
        FROM Utilisateur u
        WHERE u.email = ?1
    """)
    Optional<Utilisateur> findByUsername(String username);

}