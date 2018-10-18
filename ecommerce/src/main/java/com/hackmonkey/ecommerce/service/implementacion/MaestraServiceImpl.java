package com.hackmonkey.ecommerce.service.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackmonkey.ecommerce.entity.Maestra;
import com.hackmonkey.ecommerce.repository.interfaces.MaestraDAO;
import com.hackmonkey.ecommerce.service.interfaces.MaestraService;

@Service
public class MaestraServiceImpl implements MaestraService{

	@Autowired
	private MaestraDAO maestraDAO;
	
	@Override
	public Maestra guardar(Maestra entity) {
		return maestraDAO.save(entity);
	}

	@Override
	public List<Maestra> listar() {
		// TODO Auto-generated method stub
		return (List<Maestra>) maestraDAO.findAll();
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Maestra buscarPorId(Long id) {
		return maestraDAO.findByIdMaestra(id);
	}

	@Override
	public List<Maestra> listarTablas() {
		return maestraDAO.listarTablas();
	}

	@Override
	public Maestra guardarHijo(Maestra maestra, Long idMaestra) {
		
		Maestra tablaMaestra = buscarPorId(idMaestra);
		System.out.println(tablaMaestra.toString());
		return null;
	}

}
