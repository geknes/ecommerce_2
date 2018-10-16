package com.hackmonkey.ecommerce.service.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackmonkey.ecommerce.entity.Categoria;
import com.hackmonkey.ecommerce.repository.interfaces.CategoriaDAO;
import com.hackmonkey.ecommerce.service.interfaces.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{

	@Autowired
	private CategoriaDAO categoriaDAO;

	@Override
	public Categoria guardar(Categoria entity) {
		
		return categoriaDAO.save(entity);
	}

	@Override
	public List<Categoria> listar() {
		return (List<Categoria>) categoriaDAO.findAll();
	}

	@Override
	public void eliminar(Long id) {
		categoriaDAO.deleteById(id);
	}

	@Override
	public Categoria buscarPorId(Long id) {
		return categoriaDAO.findByIdCategoria(id);
	}
	
	
	
}
