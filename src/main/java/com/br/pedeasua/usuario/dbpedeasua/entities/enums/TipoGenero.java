package com.br.pedeasua.usuario.dbpedeasua.entities.enums;

public enum TipoGenero {
	
	MASCULINO("Masculino"),
	FEMININO("Feminino");
	
	private TipoGenero(String descricao) {
		this.genero = descricao;
	}
	
	private String genero;

	public String getGenero() {
		return genero;
	}
	
}
