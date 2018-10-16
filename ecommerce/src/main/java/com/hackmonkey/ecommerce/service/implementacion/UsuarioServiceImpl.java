package com.hackmonkey.ecommerce.service.implementacion;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackmonkey.ecommerce.entity.Usuario;
import com.hackmonkey.ecommerce.entity.seguridad.UsuarioRol;
import com.hackmonkey.ecommerce.repository.interfaces.RolDAO;
import com.hackmonkey.ecommerce.repository.interfaces.UsuarioDAO;
import com.hackmonkey.ecommerce.service.interfaces.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private RolDAO rolDAO;
	
	@Override
	public Usuario crearUsuario(Usuario usuario, Set<UsuarioRol> usuarioRols) throws Exception {
		Usuario localUser = usuarioDAO.findByUsername(usuario.getUsername());

		if (localUser != null) {
			//LOG.info("user {} already exists. Nothing will be done.", usuario.getUsername());
		} else {
			for (UsuarioRol ur : usuarioRols) {
				rolDAO.save(ur.getRol());
			}

			usuario.getUsuarioRols().addAll(usuarioRols);

			localUser = usuarioDAO.save(usuario);
		}

		return localUser;
	}

	@Override
	public Usuario guardar(Usuario usuario) {
		return usuarioDAO.save(usuario);
	}

}
