package com.br.pedeasua.usuario.dbpedeasua.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.pedeasua.usuario.dbpedeasua.dto.MusicaDto;
import com.br.pedeasua.usuario.dbpedeasua.entities.Musica;
import com.br.pedeasua.usuario.dbpedeasua.services.MusicaService;

//@RestController
@RequestMapping(value = "/musica")
public class MusicaController {
	/*
	@Autowired
	private MusicaService service;
	
	@GetMapping
	public ResponseEntity<List<Musica>> findAll(){
		List<Musica> allMusic = service.findAll();
		return ResponseEntity.ok(allMusic);
	}
	
	@PostMapping
	public ResponseEntity<Musica> save(@RequestBody Musica musica){
		Musica musicaSaved = service.save(musica);
		return ResponseEntity.ok(musicaSaved);
	}
	
	@GetMapping(value = "/busca")
	public ResponseEntity<List<MusicaDto>> findMusicaByName(@RequestParam String nome, @RequestParam String banda){
		
		List<MusicaDto> allMusicFiltrada = new ArrayList<>();
		Boolean porNome = false;
		Boolean porBanda = false;
		
		if( nome != null && !nome.equalsIgnoreCase("") ){
			porNome = true;
		}
		
		if( banda != null && !banda.equalsIgnoreCase("") ){
			porBanda = true;
		}
		
		if( porNome && porBanda ) {
			allMusicFiltrada = service.findByNomeBandaMusica(nome, banda);
		} else if ( porBanda ) {
			allMusicFiltrada = service.findByBandaMusica(banda);
		} else if ( porNome ) {
			allMusicFiltrada = service.findByNameMusica(nome);
		}
		
		return ResponseEntity.ok(allMusicFiltrada);
	}
	
	@DeleteMapping
	public void delete(@RequestBody Musica musica) {
		service.deleteMusica(musica);
	}
	*/
	
}
