package com.hackmonkey.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackmonkey.ecommerce.entity.Segmento;
import com.hackmonkey.ecommerce.repository.SegmentoDAO;
import com.hackmonkey.ecommerce.service.SegmentoService;

@Service
public class SegmentoServiceImpl implements SegmentoService{
	
	@Autowired
	SegmentoDAO segmentoDAO;
	
	public Segmento guardar(Segmento segmento)
	{
		return segmentoDAO.save(segmento);
	}
	
	public List<Segmento> listar()
	{
		return (List<Segmento>) segmentoDAO.findAll();
	}
	
}
