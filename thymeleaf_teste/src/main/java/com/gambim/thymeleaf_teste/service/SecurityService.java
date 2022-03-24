package com.gambim.thymeleaf_teste.service;

public interface SecurityService {
	boolean isAuthenticated();
    void autoLogin(String username, String password);
}
