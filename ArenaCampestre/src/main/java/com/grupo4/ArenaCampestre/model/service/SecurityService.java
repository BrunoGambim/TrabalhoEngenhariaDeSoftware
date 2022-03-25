package com.grupo4.ArenaCampestre.model.service;

public interface SecurityService {
	boolean isAuthenticated();
    void autoLogin(String username, String password);
}
