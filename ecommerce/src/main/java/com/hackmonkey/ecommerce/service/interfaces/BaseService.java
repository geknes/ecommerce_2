package com.hackmonkey.ecommerce.service.interfaces;

import java.util.List;


public interface BaseService<Entity> {

	public Entity guardar(Entity entity);
	
	public List<Entity> listar();
	
	public void eliminar(Long id);
	
	public Entity buscarPorId(Long id);
}
