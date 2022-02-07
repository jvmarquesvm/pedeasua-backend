package com.br.pedeasua.usuario.dbpedeasua.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.br.pedeasua.usuario.dbpedeasua.entities.enums.TipoGenero;

@Entity
public class Artistas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "artista_id")
	private Long artistaId;
	
	@Column(nullable = false)
	private String cpf;
	
	@Column(name = "primeiro_nome", nullable = false)
	private String primeiroNome;
	
	@Column(name = "ultimo_nome", nullable = false)
	private String ultimoNome;
	
	@Enumerated(EnumType.STRING)
	private TipoGenero genero;
	
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	
	@Column(name = "data_admissao", nullable = false)
	private LocalDate dataAdmissao;

	public Long getArtistaId() {
		return artistaId;
	}

	public void setArtistaId(Long artistaId) {
		this.artistaId = artistaId;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public TipoGenero getGenero() {
		return genero;
	}

	public void setGenero(TipoGenero genero) {
		this.genero = genero;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artistaId == null) ? 0 : artistaId.hashCode());
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
		Artistas other = (Artistas) obj;
		if (artistaId == null) {
			if (other.artistaId != null)
				return false;
		} else if (!artistaId.equals(other.artistaId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Artistas [artistaId=" + artistaId + ", cpf=" + cpf + ", primeiroNome=" + primeiroNome + ", ultimoNome="
				+ ultimoNome + ", genero=" + genero + ", dataNascimento=" + dataNascimento + ", dataAdmissao="
				+ dataAdmissao + "]";
	}
	
}
