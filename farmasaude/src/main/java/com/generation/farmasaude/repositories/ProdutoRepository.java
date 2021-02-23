package com.generation.farmasaude.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.farmasaude.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);
}
