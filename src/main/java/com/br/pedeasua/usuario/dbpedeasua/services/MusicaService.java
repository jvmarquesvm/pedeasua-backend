package com.br.pedeasua.usuario.dbpedeasua.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.pedeasua.usuario.dbpedeasua.dto.MusicaDto;
import com.br.pedeasua.usuario.dbpedeasua.entities.Musica;
import com.br.pedeasua.usuario.dbpedeasua.repositories.MusicaRepository;

//@Service
public class MusicaService {
	/*
	@Autowired
	private MusicaRepository repository;
	
	@Transactional(readOnly = false)
	public Musica save(Musica musica) {
		return repository.save(musica);
	}
	
	@Transactional(readOnly = true)
	public List<Musica> findAll() {
		return repository.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<MusicaDto> findByNameMusica(String nome) {
		return repository.musicasfiltradasPorNome(nome);
	}
		
	@Transactional(readOnly = true)
	public List<MusicaDto> findByBandaMusica(String nomeBanda) {
		return repository.musicasfiltradasPorBanda(nomeBanda);
	}
	
	@Transactional(readOnly = true)
	public List<MusicaDto> findByNomeBandaMusica(String nomeMusica, String nomeBanda) {
		return repository.musicasfiltradasPorNomeBanda(nomeMusica, nomeBanda);
	}
	
	@Transactional(readOnly = false)
	public void deleteMusica(Musica musica) {
		repository.delete(musica);
	}*/

}
