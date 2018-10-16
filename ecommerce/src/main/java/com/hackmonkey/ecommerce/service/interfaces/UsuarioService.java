package com.hackmonkey.ecommerce.service.interfaces;

import java.util.Set;

import com.hackmonkey.ecommerce.entity.Usuario;
import com.hackmonkey.ecommerce.entity.seguridad.UsuarioRol;

public interface UsuarioService {

	Usuario crearUsuario(Usuario usuario,Set<UsuarioRol> usuarioRols) throws Exception;
	
	Usuario guardar(Usuario usuario);
}
