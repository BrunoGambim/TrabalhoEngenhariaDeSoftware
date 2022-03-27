package com.grupo4.ArenaCampestre.models.enums;

public enum UserRole {
	CUSTUMER(1, "ROLE_CUSTOMER"),
	MANAGER(2, "ROLE_MANAGER");

	private int code;
	private String description;
	
	private UserRole(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public static UserRole toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		return UserRole.toEnum((int) code);
	}
	
	public static UserRole toEnum(int code) {
		for(UserRole userRole : UserRole.values()) {
			if(code == userRole.getCode()) {
				return userRole;
			}
		}
		throw new IllegalArgumentException("Argumento inválido! Id:" + code);
	}
	
	@Override
	public String toString() {
		return description;
	}
}

