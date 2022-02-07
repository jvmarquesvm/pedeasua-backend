package com.br.pedeasua.usuario.dbpedeasua.dto;

public class MusicaDto {
	
	public MusicaDto() {
	}
	
	public MusicaDto(Long id, String nome, String banda) {
		super();
		this.id = id;
		this.nome = nome;
		this.banda = banda;
	}
	private Long id;
	private String nome;
	private String banda;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getBanda() {
		return banda;
	}
	public void setBanda(String banda) {
		this.banda = banda;
	}
	
}
