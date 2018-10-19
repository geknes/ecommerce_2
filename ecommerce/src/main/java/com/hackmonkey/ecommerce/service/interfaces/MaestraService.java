package com.hackmonkey.ecommerce.service.interfaces;

import java.util.List;

import com.hackmonkey.ecommerce.entity.Maestra;

public interface MaestraService extends BaseService<Maestra>{

	public List<Maestra> listarTablas();
	
	public Maestra guardarHijo(Maestra maestra, Long idMaestra);
	

}
