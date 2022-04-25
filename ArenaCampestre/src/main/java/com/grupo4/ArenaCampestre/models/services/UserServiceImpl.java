package com.grupo4.ArenaCampestre.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.grupo4.ArenaCampestre.models.entities.Customer;
import com.grupo4.ArenaCampestre.models.entities.User;
import com.grupo4.ArenaCampestre.models.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
    	Customer custumer = new Customer();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));;
        custumer.setPassword(user.getPassword());
        custumer.setUsername(user.getUsername());
        userRepository.save(custumer);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    @Override
    public User getLoggedUser() {
    	String username = ((org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    	return findByUsername(username);
    }
}
