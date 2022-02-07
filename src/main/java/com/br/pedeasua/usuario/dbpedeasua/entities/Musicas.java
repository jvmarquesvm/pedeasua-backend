package com.br.pedeasua.usuario.dbpedeasua.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.br.pedeasua.usuario.dbpedeasua.entities.enums.TipoStatus;

@Entity
public class Musicas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "musica_id")
	private Long musicaId;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String banda;
	
	@Enumerated(EnumType.STRING)
	private TipoStatus status;
	
	@Column(name = "data_inicio", nullable = false)
	private LocalDate dataInicio;
	
	@Column(name = "data_fim", nullable = true)
	private LocalDate dataFim;

	public Long getMusicaId() {
		return musicaId;
	}

	public void setMusicaId(Long musicaId) {
		this.musicaId = musicaId;
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

	public TipoStatus getStatus() {
		return status;
	}

	public void setStatus(TipoStatus status) {
		this.status = status;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((musicaId == null) ? 0 : musicaId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musicas other = (Musicas) obj;
		if (musicaId == null) {
			if (other.musicaId != null)
				return false;
		} else if (!musicaId.equals(other.musicaId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Musicas [id=" + musicaId + ", nome=" + nome + ", banda=" + banda + ", status=" + status + ", dataInicio="
				+ dataInicio + ", dataFim=" + dataFim + "]";
	}
	
}
