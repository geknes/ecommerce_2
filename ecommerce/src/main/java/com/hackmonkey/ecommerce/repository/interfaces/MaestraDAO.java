package com.hackmonkey.ecommerce.repository.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hackmonkey.ecommerce.entity.Maestra;

public interface MaestraDAO extends CrudRepository<Maestra, Long>{

	Maestra findByIdMaestra(Long id);
	
	Maestra findByCodigoRegistro(Long codigoRegistro);
	
	@Query("select a from Maestra a where a.orden = 0")
	List<Maestra> listarTablas();
	
	@Query("select a from Maestra a where a.orden <> 0")
	List<Maestra> listarHijos();
	
	@Query("select max(a.orden) from Maestra a where a.codigoRegistro = ?1")
	Integer maxNumeroOrden(Long codigoRegistro);
}
