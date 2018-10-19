package com.hackmonkey.ecommerce.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4059789356074276296L;


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_categoria")
	private Long idCategoria; 
	
	@Column(name="nombre_categoria")
	private String nombreCategoria;
	
	@Column(name="estado")
	private boolean estado;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_segmento")
	private Segmento segmento;
	
	@OneToMany(mappedBy="categoria")
	private Set<Producto> productos;

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Segmento getSegmento() {
		return segmento;
	}

	public void setSegmento(Segmento segmento) {
		this.segmento = segmento;
	}
	
	

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", nombreCategoria=" + nombreCategoria + ", estado=" + estado
				+ ", segmento=" + segmento + ", productos=" + productos + "]";
	}

}
