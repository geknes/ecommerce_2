package com.hackmonkey.ecommerce.repository.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.hackmonkey.ecommerce.entity.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Long>{
	Usuario findByUsername(String username);
}
