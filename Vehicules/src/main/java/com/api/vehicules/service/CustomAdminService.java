package com.api.vehicules.service;

import com.api.vehicules.model.Admin;
import com.api.vehicules.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class CustomAdminService implements UserDetailsService {

    private final Admin_service admin_service;

    @Autowired
    public CustomAdminService(Admin_service admin_service) {
        this.admin_service = admin_service;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = this.admin_service.findByAdmin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new User(admin.getNom_admin(), admin.getMdp(),createAuth("admin"));
    }
    private List<GrantedAuthority> createAuth(String role){
        return Collections.singletonList(new SimpleGrantedAuthority(role.toUpperCase()));
    }

}
