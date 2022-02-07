package com.br.pedeasua.usuario.dbpedeasua.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.br.pedeasua.usuario.dbpedeasua.dto.RepertorioArtistaDto;
import com.br.pedeasua.usuario.dbpedeasua.entities.Repertorio;

public interface RepertorioRepository extends JpaRepository<Repertorio, Long> {

	@Query("Select new com.br.pedeasua.usuario.dbpedeasua.dto.RepertorioArtistaDto(reper.repertorioId, mus.nome, mus.banda, reper.status )  From Repertorio as reper, Artistas as art, Musicas as mus  Where reper.artista = art.artistaId and mus.musicaId = reper.musica and art.artistaId = ?1 ")
	public List<RepertorioArtistaDto> buscaRepertorioPorArtistaId(Long artistaId);
	
}
