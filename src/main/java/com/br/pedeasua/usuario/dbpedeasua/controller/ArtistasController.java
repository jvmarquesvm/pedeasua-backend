 package com.br.pedeasua.usuario.dbpedeasua.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.pedeasua.usuario.dbpedeasua.entities.Artistas;
import com.br.pedeasua.usuario.dbpedeasua.repositories.ArtistasRepository;

@RestController
@RequestMapping("/v2/api/artistas")
public class ArtistasController {
	
	@Autowired
	ArtistasRepository artistasRepository;
	
	@GetMapping
	public List<Artistas> buscarTodosArtistas(){
		return artistasRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Artistas buscarArtistaPorId(@PathVariable Long id) throws Exception {
		Optional<Artistas> optionalArtista = artistasRepository.findById(id);
	
		if(optionalArtista.isEmpty()) {
			throw new Exception("Artista não encontrado!" + id);
		}
		return optionalArtista.get();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Artistas criarArtista(@RequestBody Artistas artistas) {
		return artistasRepository.save(artistas);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarArtista(@PathVariable Long id ) {
		artistasRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public String atualizarArtistas(@PathVariable Long id, @RequestBody Artistas artistas) throws Exception {
		Optional<Artistas> artistaOptional = artistasRepository.findById(id);
		
		if(artistaOptional.isEmpty()) {
			throw new Exception("Artista Não Encontrado!");
		}
		
		artistasRepository.save(artistas);
		return "Artista atualizado com sucesso! id: " + id; 
		
	}
	

}
