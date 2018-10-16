package com.hackmonkey.ecommerce.service.interfaces;


import java.util.List;

import com.hackmonkey.ecommerce.entity.Segmento;

public interface SegmentoService {

	public Segmento guardar(Segmento segmento);
	
	public List<Segmento> listar();
	
	public void eliminar(Long id);
	
	public Segmento buscarPorId(Long id);
	
	//public Segmento actualizar(Segmento segmento);
}
