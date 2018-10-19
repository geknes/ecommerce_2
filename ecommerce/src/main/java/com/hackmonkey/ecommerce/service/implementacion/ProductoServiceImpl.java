package com.hackmonkey.ecommerce.service.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackmonkey.ecommerce.entity.Producto;
import com.hackmonkey.ecommerce.repository.interfaces.ProductoDAO;
import com.hackmonkey.ecommerce.service.interfaces.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	ProductoDAO productoDAO;
	
	@Override
	public Producto guardar(Producto entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> listar() {
		return (List<Producto>) productoDAO.findAll();
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
