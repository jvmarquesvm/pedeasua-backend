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

import com.br.pedeasua.usuario.dbpedeasua.dto.PedidoRepertorioDto;
import com.br.pedeasua.usuario.dbpedeasua.entities.Artistas;
import com.br.pedeasua.usuario.dbpedeasua.entities.Pedido;
import com.br.pedeasua.usuario.dbpedeasua.entities.Repertorio;
import com.br.pedeasua.usuario.dbpedeasua.entities.Usuario;
import com.br.pedeasua.usuario.dbpedeasua.entities.enums.TipoStatus;
import com.br.pedeasua.usuario.dbpedeasua.repositories.ArtistasRepository;
import com.br.pedeasua.usuario.dbpedeasua.repositories.PedidoRepository;
import com.br.pedeasua.usuario.dbpedeasua.repositories.RepertorioRepository;
import com.br.pedeasua.usuario.dbpedeasua.repositories.UsuarioRepository;

@RestController
@RequestMapping("/v2/api/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private RepertorioRepository repertorioRepositoy;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ArtistasRepository artistasRepository;

	@GetMapping
	public List<Pedido> buscaTodosPedidos(){
		return pedidoRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pedido criaPedido(@RequestBody Pedido pedido) throws Exception {
		
		Optional<Repertorio> optionalRepertorio = repertorioRepositoy.findById( pedido.getRepertorio().getRepertorioId() );
		Optional<Usuario> optionalUsuario = usuarioRepository.findById( pedido.getUsuario().getIdUsuario() );
		
		if(optionalRepertorio.isEmpty() || optionalUsuario.isEmpty() ) {
			throw new Exception("Dados relacionados estão nulos!!");
		}
		pedido.setRepertorio(optionalRepertorio.get());
		pedido.setUsuario(optionalUsuario.get());
		pedido.setDataEntrada(LocalDateTime.now());
		pedido.setDataFim(null);
		pedido.setStatus(TipoStatus.ATIVO);
				
		return pedidoRepository.save(pedido);
	}
	
	@GetMapping
	@RequestMapping("/artista/{id}")
	public List<PedidoRepertorioDto> buscaPedidoPorArtista(@PathVariable Long id) throws Exception{
		Optional<Artistas> optionalArtista = artistasRepository.findById(id);
		
		if(optionalArtista.isEmpty()) {
			throw new Exception("Artista não encontrado!!");
		}
		Artistas artistas = optionalArtista.get();
		return pedidoRepository.buscaPedidosPorArtistaId(artistas);
	}
	
	@PutMapping("/{id}")
	public Pedido atualizaStatusPedido(@PathVariable Long id, @RequestBody PedidoRepertorioDto pedidoRepertorioDto) throws Exception {
		Optional<Pedido> optionalPedido = pedidoRepository.findById(id);
		
		if(optionalPedido.isEmpty()) {
			throw new Exception("Pedido não encontrado!");
		}
		
		Pedido pedido = optionalPedido.get();
		pedido.setStatus(pedidoRepertorioDto.getStatus());
		pedido.setDataFim(LocalDateTime.now());
		
		return pedidoRepository.save(pedido);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void apagaPedido(@PathVariable Long id) {
		pedidoRepository.deleteById(id);
	}
	
}
