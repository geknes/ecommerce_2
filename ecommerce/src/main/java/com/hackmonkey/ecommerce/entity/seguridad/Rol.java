package com.hackmonkey.ecommerce.entity.seguridad;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="rol")
public class Rol implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1605853722789334912L;


	@Id
	@Column(name="id_rol")
	private int idRol;
	
	@Column(name="nombre_rol")
	private String nombreRol;
	
	@OneToMany(mappedBy = "rol", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<UsuarioRol> usuarioRols = new HashSet<>();


	public Rol() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getIdRol() {
		return idRol;
	}


	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}


	public String getNombreRol() {
		return nombreRol;
	}


	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}


	public Set<UsuarioRol> getUsuarioRols() {
		return usuarioRols;
	}


	public void setUsuarioRols(Set<UsuarioRol> usuarioRols) {
		this.usuarioRols = usuarioRols;
	}


	@Override
	public String toString() {
		return "Rol [idRol=" + idRol + ", nombreRol=" + nombreRol + ", usuarioRols=" + usuarioRols + "]";
	}

}
