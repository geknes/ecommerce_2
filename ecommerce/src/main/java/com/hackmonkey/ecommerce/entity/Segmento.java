package com.hackmonkey.ecommerce.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="segmento")
public class Segmento implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1941454314770921659L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_segmento")
	private Long idSegmento;
	
	@Column(name="nombre_segmento")
	private String nombreSegmento;
	
	@Column(name="estado")
	private boolean estado;
	
	public Segmento() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdSegmento() {
		return idSegmento;
	}
	public void setIdSegmento(Long idSegmento) {
		this.idSegmento = idSegmento;
	}
	public String getNombreSegmento() {
		return nombreSegmento;
	}
	public void setNombreSegmento(String nombreSegmento) {
		this.nombreSegmento = nombreSegmento;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Segmento [idSegmento=" + idSegmento + ", nombreSegmento=" + nombreSegmento + ", estado=" + estado + "]";
	} 
	
	
	
}
