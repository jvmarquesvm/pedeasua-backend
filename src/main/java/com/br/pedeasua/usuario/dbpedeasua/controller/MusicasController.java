package com.br.pedeasua.usuario.dbpedeasua.controller;

import java.time.LocalDate;
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

import com.br.pedeasua.usuario.dbpedeasua.entities.Musicas;
import com.br.pedeasua.usuario.dbpedeasua.repositories.MusicasRepository;

@RestController
@RequestMapping("/v2/api/musicas")
public class MusicasController {
	
	@Autowired
	MusicasRepository musicaRepository;
	
	@GetMapping
	public List<Musicas> buscarTodosMusicas(){
		return musicaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Musicas buscarTodasMusicas( @PathVariable Long id) throws Exception{
		Optional<Musicas> optionalMusica = musicaRepository.findById(id);
		
		if(optionalMusica.isEmpty()) {
			throw new Exception("Musica não encontrado!" + id);
		}
		return optionalMusica.get();
	}
	
	@PostMapping
	public Musicas criarMusicas( @RequestBody Musicas musicas){
		return musicaRepository.save(musicas);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagarMusicaPorId( @PathVariable Long id){
		musicaRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public String atualizarMusicas(@PathVariable Long id, @RequestBody Musicas musica) throws Exception{
		 Optional<Musicas> MusicaOptional = musicaRepository.findById(id);
		 
		 if(MusicaOptional.isEmpty()) {
			 throw new Exception("Musica não foi encontrada!");
		 }
		 
		 if(musica.getStatus().getDescStatus().equalsIgnoreCase("INATIVO")) {
			 musica.setDataFim(LocalDate.now());
		 } else {
			 musica.setDataFim(null);
		 }
		 
		 musicaRepository.save(musica);
		 return "Musica atualizada com sucesso! id " + id;
	}

}
