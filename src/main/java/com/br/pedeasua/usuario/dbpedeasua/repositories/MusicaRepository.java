package com.br.pedeasua.usuario.dbpedeasua.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.br.pedeasua.usuario.dbpedeasua.dto.MusicaDto;
import com.br.pedeasua.usuario.dbpedeasua.entities.Musica;

public interface MusicaRepository {//extends JpaRepository<Musica, Long> {
	
	@Query("Select new com.br.pedeasua.usuario.dbpedeasua.dto.MusicaDto(mus.id, mus.nomeTrack, mus.banda) From Musica as mus Where mus.nomeTrack like %?1% ")
	public List<MusicaDto> musicasfiltradasPorNome(String name);
	
	
	@Query("Select new com.br.pedeasua.usuario.dbpedeasua.dto.MusicaDto(mus.id, mus.nomeTrack, mus.banda) From Musica as mus Where mus.banda like %?1% ")
	public List<MusicaDto> musicasfiltradasPorBanda(String banda);
	
	
	@Query("Select new com.br.pedeasua.usuario.dbpedeasua.dto.MusicaDto(mus.id, mus.nomeTrack, mus.banda) From Musica as mus Where mus.nomeTrack like %?1% And mus.banda like %?2% ")
	public List<MusicaDto> musicasfiltradasPorNomeBanda(String name, String banda);

}
 