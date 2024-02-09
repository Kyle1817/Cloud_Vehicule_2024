package com.api.vehicules.repository;

import com.api.vehicules.model.Admin;
import com.api.vehicules.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Admin_repository extends JpaRepository<Admin, Integer> {
    @Query(value = """
        SELECT 
        a
        FROM Admin a
        WHERE a.email = ?1
    """)
    Optional<Admin> getAdminById(String username);

}
