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

import com.br.pedeasua.usuario.dbpedeasua.dto.RepertorioArtistaDto;
import com.br.pedeasua.usuario.dbpedeasua.entities.Artistas;
import com.br.pedeasua.usuario.dbpedeasua.entities.Musicas;
import com.br.pedeasua.usuario.dbpedeasua.entities.Repertorio;
import com.br.pedeasua.usuario.dbpedeasua.repositories.ArtistasRepository;
import com.br.pedeasua.usuario.dbpedeasua.repositories.MusicasRepository;
import com.br.pedeasua.usuario.dbpedeasua.repositories.RepertorioRepository;

@RestController
@RequestMapping("/v2/api/repertorio")
public class RepertorioController {
	
	@Autowired
	RepertorioRepository repertorioRepository;
	@Autowired
	MusicasRepository musicasRepository;
	@Autowired
	ArtistasRepository artistasRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Repertorio criaRepertorio(@RequestBody Repertorio repertorio) throws Exception {
		
		Optional<Musicas> optionalMusica = musicasRepository.findById(repertorio.getMusica().getMusicaId());
		Optional<Artistas> optionalArtista = artistasRepository.findById(repertorio.getArtista().getArtistaId());
		
		if(optionalMusica.isEmpty() || optionalArtista.isEmpty() ) {
			throw new Exception("Dados relacionados estão nulos");
		}
		repertorio.setArtista(optionalArtista.get());
		repertorio.setMusica(optionalMusica.get());
		
		return repertorioRepository.save(repertorio);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarRepertorio(@PathVariable Long id) {
		repertorioRepository.deleteById(id);
	}
	
	@GetMapping("/artista/{id}")
	public List<RepertorioArtistaDto> buscaRepertorioPorArtistaId(@PathVariable Long id){
		return repertorioRepository.buscaRepertorioPorArtistaId(id);
	}
	
	@PutMapping("/{id}")
	public String inativaArtistaRepertorioId(@PathVariable Long id, @RequestBody RepertorioArtistaDto repertorio ) throws Exception {
		
		if ( id == repertorio.getIdRepertorio() ) {
			Optional<Repertorio> repertorioOptional = repertorioRepository.findById(id);
			
			if (repertorioOptional.isEmpty()) {
				throw new Exception("Repertorio Não Encontrado!");
			}
			Repertorio repertorio2 = repertorioOptional.get();
			repertorio2.setStatus(repertorio.getStatus());
			repertorioRepository.save(repertorio2);
		} else {
			throw new Exception("Id de Repertorio divergentes!");
		}
		
		return "Repertorio inativado sucesso! id: " + id; 
	}

}
