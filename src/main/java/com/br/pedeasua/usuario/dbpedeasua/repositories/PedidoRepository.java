package com.br.pedeasua.usuario.dbpedeasua.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.br.pedeasua.usuario.dbpedeasua.dto.PedidoRepertorioDto;
import com.br.pedeasua.usuario.dbpedeasua.entities.Artistas;
import com.br.pedeasua.usuario.dbpedeasua.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	@Query("Select new com.br.pedeasua.usuario.dbpedeasua.dto.PedidoRepertorioDto(p.idPedido, m.nome, m.banda, p.dataEntrada, u.primeiroNome, p.status) \r\n"
			+ " From Pedido as p, Repertorio as r, Usuario as u, Artistas as a, Musicas as m \r\n"
			+ "  Where p.repertorio = r.repertorioId \r\n"
			+ "     and p.usuario = u.idUsuario \r\n"
			+ "      and r.artista =  a.artistaId \r\n"
			+ "       and r.musica = m.musicaId \r\n"
			+ "        and  r.artista = ?1 \r\n"
			+ "      order by p.dataEntrada desc")
	public List<PedidoRepertorioDto> buscaPedidosPorArtistaId(Artistas artista);

}
