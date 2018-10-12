package com.hackmonkey.ecommerce.service;


import java.util.List;

import com.hackmonkey.ecommerce.entity.Segmento;

public interface SegmentoService {

	public Segmento guardar(Segmento segmento);
	
	public List<Segmento> listar();
}
