package com.grupo4.ArenaCampestre.models.enums;

public enum Sector {
	UPPER_WEST(1, "Oeste superior"),
	MIDDLE_WEST(2, "Oeste intermediario"),
	LOWER_WEST(3, "Oeste inferior"),
	UPPER_EAST(4, "Leste superior"),
	MIDDLE_EAST(5, "Leste intermediario"),
	LOWER_EAST(6, "Leste inferior"),
	UPPER_NORTH(7, "Norte superior"),
	LOWER_NORTH(8, "Norte inferior"),
	UPPER_SOUTH(9, "Sul superior"),
	LOWER_SOUTH(10, "Sul inferior");

	private int code;
	private String description;
	
	private Sector(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public static Sector toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		return Sector.toEnum((int) code);
	}
	
	public static Sector toEnum(int code) {
		for(Sector sector : Sector.values()) {
			if(code == sector.getCode()) {
				return sector;
			}
		}
		throw new IllegalArgumentException("Argumento inválido! Id:" + code);
	}
	
	@Override
	public String toString() {
		return description;
	}
}
