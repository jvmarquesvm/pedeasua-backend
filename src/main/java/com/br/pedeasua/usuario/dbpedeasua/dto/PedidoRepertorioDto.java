package com.br.pedeasua.usuario.dbpedeasua.dto;

import java.time.LocalDateTime;

import com.br.pedeasua.usuario.dbpedeasua.entities.enums.TipoStatus;

public class PedidoRepertorioDto {
	
	private Long pedidoId;
	private String nome;
	private String banda;
	private LocalDateTime dataEntrada;
	private String autor;
	private TipoStatus status;
	
	public PedidoRepertorioDto(Long pedidoId, String nome, String banda, 
			              LocalDateTime dataEntrada, String autor, TipoStatus status) {
		super();
		this.pedidoId = pedidoId;
		this.nome = nome;
		this.banda = banda;
		this.dataEntrada = dataEntrada;
		this.autor = autor;
		this.status = status;
	}
	
	public Long getPedidoId() {
		return pedidoId;
	}
	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
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
	public LocalDateTime getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public TipoStatus getStatus() {
		return status;
	}
	public void setStatus(TipoStatus status) {
		this.status = status;
	}
}
