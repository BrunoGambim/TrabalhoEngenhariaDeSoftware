package com.grupo4.ArenaCampestre.models.services;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupo4.ArenaCampestre.models.entities.Customer;
import com.grupo4.ArenaCampestre.models.entities.Manager;
import com.grupo4.ArenaCampestre.models.entities.User;
import com.grupo4.ArenaCampestre.models.enums.Perfil;
import com.grupo4.ArenaCampestre.models.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        
        if(user instanceof Manager) {
        	grantedAuthorities.add(new SimpleGrantedAuthority(Perfil.MANAGER.getDescription()));
        }
        if(user instanceof Customer) {
        	grantedAuthorities.add(new SimpleGrantedAuthority(Perfil.CUSTUMER.getDescription()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
