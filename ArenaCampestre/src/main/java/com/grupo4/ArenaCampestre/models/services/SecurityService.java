package com.grupo4.ArenaCampestre.models.services;

public interface SecurityService {
	boolean isAuthenticated();
    void autoLogin(String username, String password);
}
