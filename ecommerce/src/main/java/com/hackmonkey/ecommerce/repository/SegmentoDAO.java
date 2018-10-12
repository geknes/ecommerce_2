package com.hackmonkey.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.hackmonkey.ecommerce.entity.Segmento;

public interface SegmentoDAO extends CrudRepository<Segmento, Long>{
	Segmento findByNombreSegmento(String nombreSegmento);
}
