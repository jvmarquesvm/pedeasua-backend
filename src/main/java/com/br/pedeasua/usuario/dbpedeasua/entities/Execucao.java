package com.br.pedeasua.usuario.dbpedeasua.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
@Table(name = "tb_execucao_musica")
public class Execucao {
	
	public Execucao() {
		
	}
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	
}
