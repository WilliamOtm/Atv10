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

import com.atividade.demo.entity.Categoria;
import com.atividade.demo.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired
	CategoriaService categoriaService;
	
	// Endpoint para obter todas as categorias
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll(){
		List<Categoria> categorias = categoriaService.getAll();
		if(!categorias.isEmpty())
			return new ResponseEntity<>(categorias, HttpStatus.OK);
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	// Endpoint para obter uma categoria pelo ID
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable Integer id) {
		Categoria categoria = categoriaService.getById(id);
		if(categoria != null)
			return new ResponseEntity<>(categoria, HttpStatus.OK); 
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);		
	}
	
	// Endpoint para salvar uma nova categoria
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Categoria> salvarCategoria(@RequestBody Categoria categoria) {
		return new ResponseEntity<>(categoriaService.salvarCategoria(categoria), HttpStatus.CREATED);
	}
	
	// Endpoint para atualizar uma categoria existente
	@PutMapping("/{id}")
	public ResponseEntity<Categoria> updateCategoria(@PathVariable Integer id, @RequestBody Categoria categoria) {
		Categoria categoriaAtualizada = categoriaService.updateCategoria(id, categoria);
		if(categoriaAtualizada != null)
			return new ResponseEntity<>(categoriaAtualizada, HttpStatus.OK); 
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	// Endpoint para excluir uma categoria
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Boolean> deleteCategoria(@PathVariable Integer id) {
		if(categoriaService.deleteCategoria(id))
			return new ResponseEntity<>(true, HttpStatus.OK);
		else 
			return new ResponseEntity<>(false, HttpStatus.OK);
	}
}
