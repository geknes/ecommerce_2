package com.hackmonkey.ecommerce.entity.seguridad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hackmonkey.ecommerce.entity.Usuario;

@Entity
@Table(name="usuario_rol")
public class UsuarioRol implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7392545471928120338L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_usuario_rol")
	private Long IdUsuarioRol;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_rol")
	private Rol rol;

	public UsuarioRol() {
		super();
	}
	
	

	public UsuarioRol(Usuario usuario, Rol rol) {
		this.usuario = usuario;
		this.rol = rol;
	}



	public Long getIdUsuarioRol() {
		return IdUsuarioRol;
	}

	public void setIdUsuarioRol(Long idUsuarioRol) {
		IdUsuarioRol = idUsuarioRol;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "UsuarioRol [IdUsuarioRol=" + IdUsuarioRol + ", usuario=" + usuario + ", rol=" + rol + "]";
	}
	
	
}
