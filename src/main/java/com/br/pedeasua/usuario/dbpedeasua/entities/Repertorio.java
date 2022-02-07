package com.br.pedeasua.usuario.dbpedeasua.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.br.pedeasua.usuario.dbpedeasua.entities.enums.TipoStatus;

@Entity
public class Repertorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "repertorio_id")
	private Long repertorioId;
	
	@Column(name = "data_inicio", nullable = false)
	private LocalDate dataInicio;
	
	@Column(name = "data_fim", nullable = true)
	private LocalDate dataFim;
	
	@Enumerated(EnumType.STRING)
	private TipoStatus status;
	
	@OneToOne
	@JoinColumn(name = "artista_id")
	private Artistas artista;
	
	@ManyToOne
	@JoinColumn(name = "musica_id")
	private Musicas musica;
	
	public Long getRepertorioId() {
		return repertorioId;
	}

	public void setRepertorioId(Long repertorioId) {
		this.repertorioId = repertorioId;
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
	
	public TipoStatus getStatus() {
		return status;
	}
	
	public void setStatus(TipoStatus status) {
		this.status = status;
	}
	
	public Artistas getArtista() {
		return artista;
	}
	
	public void setArtista(Artistas artista) {
		this.artista = artista;
	}
	
	public Musicas getMusica() {
		return musica;
	}
	
	public void setMusica(Musicas musica) {
		this.musica = musica;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((repertorioId == null) ? 0 : repertorioId.hashCode());
		result = prime * result + ((musica == null) ? 0 : musica.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Repertorio other = (Repertorio) obj;
		if (repertorioId == null) {
			if (other.repertorioId != null)
				return false;
		} else if (!repertorioId.equals(other.repertorioId))
			return false;
		if (musica == null) {
			if (other.musica != null)
				return false;
		} else if (!musica.equals(other.musica))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Repertorio [id=" + repertorioId + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", status=" + status
				+ ", artista=" + artista + ", musica=" + musica + "]";
	}
	
}
