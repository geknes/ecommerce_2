package com.hackmonkey.ecommerce.entity.seguridad;

import org.springframework.security.core.GrantedAuthority;

public class Autoridad implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9003611172575249731L;
	
	private final String autoridad;
	
	public Autoridad(String autoridad) {
		this.autoridad = autoridad;
	}
	
	@Override
	public String getAuthority() {
		return autoridad;
	}

}
