package com.hackmonkey.ecommerce.repository.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.hackmonkey.ecommerce.entity.Categoria;

public interface CategoriaDAO extends CrudRepository<Categoria, Long>{
	Categoria findByIdCategoria(Long id);
}
