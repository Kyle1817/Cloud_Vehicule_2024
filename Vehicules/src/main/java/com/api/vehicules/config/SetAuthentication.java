package com.api.vehicules.config;

import com.api.vehicules.service.CustomAdminService;
import com.api.vehicules.service.CustomUtilisateurService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class SetAuthentication extends OncePerRequestFilter {

    @Autowired
    private token jwt;
    @Autowired
    private CustomUtilisateurService utilisateurService;
    @Autowired
    private CustomAdminService adminService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = this.getJWTFromRequest(request);
        if (StringUtils.hasText(token)) {
            try {
                jwt.validateToken(token);
                String usename = jwt.getUsername(token);
                UserDetails userDetails;
                try{
                    userDetails = utilisateurService.loadUserByUsername(usename);
                }catch (UsernameNotFoundException unf) {
                    userDetails = adminService.loadUserByUsername(usename);
                }
                UsernamePasswordAuthenticationToken
                        authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                );

                SecurityContextHolder.getContext().setAuthentication(authToken);
            }catch (AuthenticationCredentialsNotFoundException e) {
                logger.error("AuthenticationCredentialsNotFoundException: " + e.getMessage());

            }
        }

        filterChain.doFilter(request, response);
    }

    private String getJWTFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
