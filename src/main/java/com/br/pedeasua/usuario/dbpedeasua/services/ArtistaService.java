package com.br.pedeasua.usuario.dbpedeasua.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.pedeasua.usuario.dbpedeasua.entities.Artista;
import com.br.pedeasua.usuario.dbpedeasua.repositories.ArtistaRepository;

//@Service
public class ArtistaService {
	/*
	@Autowired
	private ArtistaRepository repository;
	
	@Transactional(readOnly = true)
	public List<Artista> findAll() {
		//return repository.findAll();
		return null;
	}
	
	@Transactional(readOnly = false)
	public Artista save( Artista artista) {
		//return repository.save(artista);
		return null;
	}
	
	@Transactional(readOnly = false)
	public Artista repertorio(Artista artista) {
		
		Optional<Artista> optionalArtista = repository.findById( artista.getId() );
		
		if ( !optionalArtista.isPresent() ) {
			return null;
		}
		
		artista.getMusicas().removeAll(optionalArtista.get().getMusicas());
		return repository.save(artista);
	}
	
	@Transactional(readOnly = false)
	public void delete(Artista artista) {
		repository.delete(artista);
	}
	*/
}
