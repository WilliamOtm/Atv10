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

import com.atividade.demo.entity.Produto;
import com.atividade.demo.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	// Endpoint para obter todos os produtos
	@GetMapping
	public ResponseEntity<List<Produto>> getAll(){
		List<Produto> produtos = produtoService.getAll();
		if(!produtos.isEmpty())
			return new ResponseEntity<>(produtos, HttpStatus.OK);
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	// Endpoint para obter um produto pelo ID
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable Integer id) {
		Produto produto = produtoService.getById(id);
		if(produto != null)
			return new ResponseEntity<>(produto, HttpStatus.OK); 
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);		
	}
	
	// Endpoint para salvar um novo produto
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
		return new ResponseEntity<>(produtoService.salvarProduto(produto), HttpStatus.CREATED);
	}
	
	// Endpoint para atualizar um produto existente
	@PutMapping("/{id}")
	public ResponseEntity<Produto> updateProduto(@PathVariable Integer id, @RequestBody Produto produto) {
		Produto produtoAtualizada = produtoService.updateProduto(id, produto);
		if(produtoAtualizada != null)
			return new ResponseEntity<>(produtoAtualizada, HttpStatus.OK); 
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	// Endpoint para excluir um produto
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Boolean> deleteProduto(@PathVariable Integer id) {
		if(produtoService.deleteProduto(id))
			return new ResponseEntity<>(true, HttpStatus.OK);
		else 
			return new ResponseEntity<>(false, HttpStatus.OK);
	}
}
