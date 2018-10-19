package com.hackmonkey.ecommerce.repository.interfaces;

import org.springframework.data.repository.CrudRepository;

import com.hackmonkey.ecommerce.entity.Producto;

public interface ProductoDAO extends CrudRepository<Producto, Long>{

}
