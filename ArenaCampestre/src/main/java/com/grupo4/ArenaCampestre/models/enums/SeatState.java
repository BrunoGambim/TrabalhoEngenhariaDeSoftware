package com.grupo4.ArenaCampestre.models.enums;

public enum SeatState {
	AVAILABLE_TO_BUY(1, "Disponivel para venda"),
	AVAILABLE_TO_RENT(2, "Disponivel para aluguel"),
	SOLD(3, "Vendida");
	
	private int code;
	private String description;
	
	private SeatState(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public static SeatState toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		return SeatState.toEnum((int) code);
	}
	
	public static SeatState toEnum(int code) {
		for(SeatState seatState : SeatState.values()) {
			if(code == seatState.getCode()) {
				return seatState;
			}
		}
		throw new IllegalArgumentException("Argumento inválido! Id:" + code);
	}
	
	@Override
	public String toString() {
		return description;
	}
}
