package com.hackmonkey.ecommerce.repository.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.hackmonkey.ecommerce.entity.seguridad.Rol;

public interface RolDAO extends CrudRepository<Rol, Long>{
	Rol findByNombreRol(String nombreRol);
}
