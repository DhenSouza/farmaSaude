package com.generation.farmasaude.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.generation.farmasaude.model.Categoria;
import com.generation.farmasaude.repositories.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	@Autowired
	private CategoriaRepository descricaoRepository;
	
	@GetMapping
	public ResponseEntity<List <Categoria>>  findAllCategoria(){
		return ResponseEntity.ok(descricaoRepository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findByIDCategoria(@PathVariable long id){
		return descricaoRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Categoria>> findByNome(@PathVariable String descricao){
		return ResponseEntity.ok(descricaoRepository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity<Categoria> postCategoria(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(descricaoRepository.save(categoria));
	}
	@PutMapping
	public ResponseEntity<Categoria> putCategoria(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(descricaoRepository.save(categoria)); 
	}
	
	@DeleteMapping("/{id}")
	public void deletePostagem(@PathVariable long id) {
		descricaoRepository.deleteById(id);
	}
}
