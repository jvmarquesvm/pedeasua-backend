package com.br.pedeasua.usuario.dbpedeasua.entities.enums;

public enum TipoStatus {
	
	ATIVO("Ativo"),
	INATIVO("Inativo");
	
	private TipoStatus(String status ) {
		this.descStatus = status;
	}
	
	private String descStatus;

	public String getDescStatus() {
		return descStatus;
	}
	
}
