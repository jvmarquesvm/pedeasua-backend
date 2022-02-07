package com.br.pedeasua.usuario.dbpedeasua.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.pedeasua.usuario.dbpedeasua.entities.Artista;
import com.br.pedeasua.usuario.dbpedeasua.services.ArtistaService;

//@RestController
@RequestMapping(value = "/artista")
public class ArtistaController {
	@Autowired
	private ArtistaService service;
	
/*	@GetMapping
	public ResponseEntity<List<Artista>> findAll() {
		List<Artista> listArtistas = service.findAll();
		return ResponseEntity.ok(listArtistas);
	}
	
	@PostMapping
	public ResponseEntity<Artista> save(@RequestBody Artista artista){
		Artista artistaSalvo = service.save(artista);
		return ResponseEntity.ok(artistaSalvo);
	}
	
	@PostMapping(value = "/repertorio")
	public ResponseEntity<Artista> saveRepertorio(@RequestBody Artista artista ){
		try {
			Artista repertorioSave = service.repertorio(artista);
			
			if ( repertorioSave == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			return ResponseEntity.ok(repertorioSave);
		} catch(EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
		} catch(JpaObjectRetrievalFailureException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping
	public void deleteArtista(@RequestBody Artista artista) {
		service.delete(artista);
	} */
}
