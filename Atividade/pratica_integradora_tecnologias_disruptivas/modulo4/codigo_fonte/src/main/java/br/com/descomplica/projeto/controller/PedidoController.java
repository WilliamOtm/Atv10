package com.atividade.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.atividade.demo.entity.Pedido;
import com.atividade.demo.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	@Autowired
	PedidoService pedidoService;
	
	// Endpoint para obter todos os pedidos
	@GetMapping
	public ResponseEntity<List<Pedido>> getAll(){
		List<Pedido> pedidos = pedidoService.getAll();
		if(!pedidos.isEmpty())
			return new ResponseEntity<>(pedidos, HttpStatus.OK);
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	// Endpoint para obter um pedido pelo ID
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> getById(@PathVariable Integer id) {
		Pedido pedido = pedidoService.getById(id);
		if(pedido != null)
			return new ResponseEntity<>(pedido, HttpStatus.OK); 
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);		
	}
	
	// Endpoint para salvar um novo pedido
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Pedido> salvarPedido(@RequestBody Pedido pedido) {
		return new ResponseEntity<>(pedidoService.salvarPedido(pedido), HttpStatus.CREATED);
	}
	
	// Endpoint para atualizar um pedido existente
	@PutMapping("/{id}")
	public ResponseEntity<Pedido> updatePedido(@PathVariable Integer id, @RequestBody Pedido pedido) {
		Pedido pedidoAtualizado = pedidoService.updatePedido(id, pedido);
		if(pedidoAtualizado != null)
			return new ResponseEntity<>(pedidoAtualizado, HttpStatus.OK); 
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	// Endpoint para excluir um pedido
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Boolean> deletePedido(@PathVariable Integer id) {
		if(pedidoService.deletePedido(id))
			return new ResponseEntity<>(true, HttpStatus.OK);
		else 
			return new ResponseEntity<>(false, HttpStatus.OK);
	}
}
