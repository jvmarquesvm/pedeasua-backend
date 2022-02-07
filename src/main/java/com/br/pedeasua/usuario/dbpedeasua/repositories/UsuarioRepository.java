package com.br.pedeasua.usuario.dbpedeasua.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.pedeasua.usuario.dbpedeasua.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
