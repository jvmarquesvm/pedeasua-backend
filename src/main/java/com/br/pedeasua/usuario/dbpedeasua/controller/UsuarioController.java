package com.br.pedeasua.usuario.dbpedeasua.controller;

import java.time.LocalDateTime;
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

import com.br.pedeasua.usuario.dbpedeasua.entities.Usuario;
import com.br.pedeasua.usuario.dbpedeasua.repositories.UsuarioRepository;

@RestController
@RequestMapping("/v2/api/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@PostMapping
	public Usuario criaUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@GetMapping
	public List<Usuario> buscaTodosUsuarios() {
		return usuarioRepository.findAll();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagaUsuarioId(@PathVariable Long id) {
		usuarioRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public String atualizaUsuario(@PathVariable Long id, @RequestBody Usuario usuario) throws Exception {
		
		if ( id == usuario.getIdUsuario() ) {
			Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
			
			if(optionalUsuario.isEmpty()) {
				throw new Exception("Usuario não encontrado!");
			}
			
			if ( usuario.getStatus().getDescStatus().equalsIgnoreCase("INATIVO") ) {
				usuario.setDataFim(LocalDateTime.now());
			} else {
				usuario.setDataFim(null);
			}
			
			usuarioRepository.save(usuario);
		} else {
			throw new Exception("Id de Usuario divergentes!");
		}
		return "Usuario atualizado com sucesso " + id;
	}

}
