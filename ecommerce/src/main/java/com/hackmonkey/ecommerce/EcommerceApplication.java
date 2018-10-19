package com.hackmonkey.ecommerce;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hackmonkey.ecommerce.entity.Maestra;
import com.hackmonkey.ecommerce.entity.Segmento;
import com.hackmonkey.ecommerce.entity.Usuario;
import com.hackmonkey.ecommerce.entity.seguridad.Rol;
import com.hackmonkey.ecommerce.entity.seguridad.UsuarioRol;
import com.hackmonkey.ecommerce.service.interfaces.MaestraService;
import com.hackmonkey.ecommerce.service.interfaces.SegmentoService;
import com.hackmonkey.ecommerce.service.interfaces.UsuarioService;
import com.hackmonkey.ecommerce.util.SeguridadUtilidad;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner{

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	SegmentoService segmentoService;
	
	@Autowired
	MaestraService maestraService;
	
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		
		Usuario user1 = new Usuario();
		user1.setUsername("admin");
		user1.setPrimerNombre("Jorge");
		user1.setApellido("Graza");
		user1.setPassword(SeguridadUtilidad.passwordEncoder().encode("admin"));
		//user1.setPassword("admin");
		user1.setEmail("admin@gmail.com");
		Set<UsuarioRol> usuarioRols = new HashSet<>();
		Rol role1= new Rol();
		role1.setIdRol(0);
		role1.setNombreRol("ROLE_ADMIN");
		usuarioRols.add(new UsuarioRol(user1, role1));
		System.out.println("INICIO RUN()");
		usuarioService.crearUsuario(user1, usuarioRols);
		
		
		Segmento segmento = new Segmento();
		segmento.setNombreSegmento("HOMBRE");
		segmento.setEstado(true);
		segmentoService.guardar(segmento);
		
		Segmento segmento2 = new Segmento();
		segmento2.setNombreSegmento("MUJER");
		segmento2.setEstado(true);
		segmentoService.guardar(segmento2);
		
		Segmento segmento3 = new Segmento();
		segmento3.setNombreSegmento("HOGAR");
		segmento3.setEstado(true);
		segmentoService.guardar(segmento3);
		
		Maestra maestra = new Maestra();
		maestra.setCodigoRegistro(1L);
		maestra.setEstado(true);
		maestra.setNombreCorto("TALLAS");
		maestra.setOrden(0);
		maestra.setSweditable(true);
		maestra.setValor1("NOMBRE DE TABLA");
		maestraService.guardar(maestra);
		
		Maestra maestra2 = new Maestra();
		maestra2.setCodigoRegistro(2L);
		maestra2.setEstado(true);
		maestra2.setNombreCorto("SEXO");
		maestra2.setOrden(0);
		maestra2.setSweditable(true);
		maestra2.setValor1("NOMBRE DE TABLA");
		maestraService.guardar(maestra2);
		
		Maestra maestra3 = new Maestra();
		maestra3.setCodigoRegistro(3L);
		maestra3.setEstado(true);
		maestra3.setNombreCorto("COLOR");
		maestra3.setOrden(0);
		maestra3.setSweditable(true);
		maestra3.setValor1("NOMBRE DE TABLA");
		maestraService.guardar(maestra3);
		
	}
}
