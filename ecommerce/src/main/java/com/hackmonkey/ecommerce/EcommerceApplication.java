package com.hackmonkey.ecommerce;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hackmonkey.ecommerce.entity.Usuario;
import com.hackmonkey.ecommerce.entity.seguridad.Rol;
import com.hackmonkey.ecommerce.entity.seguridad.UsuarioRol;
import com.hackmonkey.ecommerce.service.UsuarioService;

@SpringBootApplication
public class EcommerceApplication {

	@Autowired
	UsuarioService usuarioService;
	
	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		Usuario user1 = new Usuario();
		user1.setUsername("admin");
		//user1.setPassword(SecurityUtility.passwordEncoder().encode("admin"));
		user1.setPassword("admin");
		user1.setEmail("admin@gmail.com");
		Set<UsuarioRol> usuarioRols = new HashSet<>();
		Rol role1= new Rol();
		role1.setIdRol(0);
		role1.setNombreRol("ROLE_ADMIN");
		usuarioRols.add(new UsuarioRol(user1, role1));
		System.out.println("INICIO RUN()");
		usuarioService.crearUsuario(user1, usuarioRols);
	}
}
