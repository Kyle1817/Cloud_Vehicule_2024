package com.api.vehicules.service;

import com.api.vehicules.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CustomUtilisateurService implements UserDetailsService {

    private final Utilisateur_service utilisateurService;

    @Autowired
    public CustomUtilisateurService(Utilisateur_service utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = this.utilisateurService.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new User(utilisateur.getNom(), utilisateur.getMdp(),createAuth("simple"));
    }
    private List<GrantedAuthority> createAuth(String role) {
        return Collections.singletonList(new SimpleGrantedAuthority(role.toUpperCase()));
    }

}
