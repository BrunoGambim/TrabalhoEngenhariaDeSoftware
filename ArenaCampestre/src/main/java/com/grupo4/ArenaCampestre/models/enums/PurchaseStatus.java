package com.grupo4.ArenaCampestre.models.enums;

public enum PurchaseStatus {
	ACTIVE(1),
	INACTIVE(2);

	private int code;
	
	private PurchaseStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public static PurchaseStatus toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		return PurchaseStatus.toEnum((int) code);
	}
	
	public static PurchaseStatus toEnum(int code) {
		for(PurchaseStatus purchaseStatus : PurchaseStatus.values()) {
			if(code == purchaseStatus.getCode()) {
				return purchaseStatus;
			}
		}
		throw new IllegalArgumentException("Argumento inválido! Id:" + code);
	}
}
