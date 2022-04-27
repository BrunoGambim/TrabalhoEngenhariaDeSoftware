package com.grupo4.ArenaCampestre.models.enums;

public enum TransactionTypes {
	RENT(1, "Aluguel"),
	SALE(2, "Venda"),
	COMPRA(3, "Compra");

	private int code;
	private String description;
	
	private TransactionTypes(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public static TransactionTypes toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		return TransactionTypes.toEnum((int) code);
	}
	
	public static TransactionTypes toEnum(int code) {
		for(TransactionTypes transactionType : TransactionTypes.values()) {
			if(code == transactionType.getCode()) {
				return transactionType;
			}
		}
		throw new IllegalArgumentException("Argumento inválido! Id:" + code);
	}
	
	@Override
	public String toString() {
		return description;
	}
}
