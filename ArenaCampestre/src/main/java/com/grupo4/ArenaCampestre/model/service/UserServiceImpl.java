package com.grupo4.ArenaCampestre.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.grupo4.ArenaCampestre.model.entities.Customer;
import com.grupo4.ArenaCampestre.model.entities.User;
import com.grupo4.ArenaCampestre.model.repository.UserRepository;

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
}
