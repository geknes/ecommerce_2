package com.hackmonkey.ecommerce;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hackmonkey.ecommerce.entity.Segmento;
import com.hackmonkey.ecommerce.entity.Usuario;
import com.hackmonkey.ecommerce.entity.seguridad.Rol;
import com.hackmonkey.ecommerce.entity.seguridad.UsuarioRol;
import com.hackmonkey.ecommerce.service.interfaces.SegmentoService;
import com.hackmonkey.ecommerce.service.interfaces.UsuarioService;
import com.hackmonkey.ecommerce.util.SeguridadUtilidad;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner{

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	SegmentoService segmentoService;
	
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
	}
}
