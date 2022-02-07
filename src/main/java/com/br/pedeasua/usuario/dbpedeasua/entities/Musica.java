package com.br.pedeasua.usuario.dbpedeasua.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
@Table(name = "tb_musica")
public class Musica {
	
	public Musica() {
	}
	
	public Musica(Long id, String nomeTrack, String banda,  String status) {
		super();
		this.id = id;
		this.nomeTrack = nomeTrack;
		this.banda = banda;
		this.status = status;
	}
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	@Column(name = "banda_musica")
	private String banda; 
	@Column(name = "musica_nome")
	private String nomeTrack;
	@Column(name = "musica_status")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeTrack() {
		return nomeTrack;
	}

	public void setNomeTrack(String nomeTrack) {
		this.nomeTrack = nomeTrack;
	}

	public String getBanda() {
		return banda;
	}

	public void setBanda(String banda) {
		this.banda = banda;
	}

}
