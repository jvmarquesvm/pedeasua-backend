package com.br.pedeasua.usuario.dbpedeasua.dto;

import com.br.pedeasua.usuario.dbpedeasua.entities.enums.TipoStatus;

public class RepertorioArtistaDto {
	
	private Long idRepertorio;
	private String nomeMusica;
	private String nomeBanda;
	private TipoStatus status;
	
	public RepertorioArtistaDto(Long idRepertorio, String nomeMusica, String nomeBanda, TipoStatus status) {
		super();
		this.idRepertorio = idRepertorio;
		this.nomeMusica = nomeMusica;
		this.nomeBanda = nomeBanda;
		this.status = status;
	}
	
	public Long getIdRepertorio() {
		return idRepertorio;
	}
	public void setIdRepertorio(Long idRepertorio) {
		this.idRepertorio = idRepertorio;
	}
	public String getNomeMusica() {
		return nomeMusica;
	}
	public void setNomeMusica(String nomeMusica) {
		this.nomeMusica = nomeMusica;
	}
	public String getNomeBanda() {
		return nomeBanda;
	}
	public void setNomeBanda(String nomeBanda) {
		this.nomeBanda = nomeBanda;
	}
	public TipoStatus getStatus() {
		return status;
	}
	public void setStatus(TipoStatus status) {
		this.status = status;
	}
}
