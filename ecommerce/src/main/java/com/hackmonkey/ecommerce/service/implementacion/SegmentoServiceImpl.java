package com.hackmonkey.ecommerce.service.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackmonkey.ecommerce.entity.Segmento;
import com.hackmonkey.ecommerce.repository.interfaces.SegmentoDAO;
import com.hackmonkey.ecommerce.service.interfaces.SegmentoService;

@Service
public class SegmentoServiceImpl implements SegmentoService{
	
	@Autowired
	private SegmentoDAO segmentoDAO;
	
	public Segmento guardar(Segmento segmento)
	{
		return segmentoDAO.save(segmento);
	}
	
	public List<Segmento> listar()
	{
		return (List<Segmento>) segmentoDAO.findAll();
	}

	@Override
	public void eliminar(Long id) {
		segmentoDAO.deleteById(id);
	}

	@Override
	public Segmento buscarPorId(Long id) {
		return segmentoDAO.findByIdSegmento(id);
	}

//	@Override
//	public Segmento actualizar(Segmento segmento) {
//		return segmentoDAO.updateSegmento(segmento);
//	}
	
}
