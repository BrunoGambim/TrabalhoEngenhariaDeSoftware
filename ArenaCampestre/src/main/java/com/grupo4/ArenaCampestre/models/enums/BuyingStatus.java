package com.grupo4.ArenaCampestre.models.enums;

public enum BuyingStatus {
	ACTIVE(1),
	INACTIVE(2);

	private int code;
	
	private BuyingStatus(int code) {
		this.code = code;
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
}
