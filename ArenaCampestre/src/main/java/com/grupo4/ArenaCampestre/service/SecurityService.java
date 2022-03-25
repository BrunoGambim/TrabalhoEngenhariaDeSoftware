package com.grupo4.ArenaCampestre.service;

public interface SecurityService {
	boolean isAuthenticated();
    void autoLogin(String username, String password);
}
