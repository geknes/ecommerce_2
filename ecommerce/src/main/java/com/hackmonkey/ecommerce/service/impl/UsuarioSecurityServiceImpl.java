package com.hackmonkey.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hackmonkey.ecommerce.entity.Usuario;
import com.hackmonkey.ecommerce.repository.UsuarioDAO;

@Service
public class UsuarioSecurityServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDAO.findByUsername(username);
		System.out.println(username);
		if(null == usuario)
		{
			throw new UsernameNotFoundException("No se encontro el usuario.");
		}
		
		//System.out.println(usuario.toString());
		
		return usuario;
	}

}
