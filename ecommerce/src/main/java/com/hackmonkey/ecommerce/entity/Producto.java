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
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="producto")
public class Producto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7711500829042697137L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_producto")
	private Long idProducto;
	
	@Column(name="nombre_producto")
	private String nombreProducto;
	
	@Column(columnDefinition="text",name="descripcion")
	private String descripcion;
	
	@Column(name="detalle")
	private String detalle;
	
	@Column(name="stock")
	private int stock;
	
	@Column(name="precio_venta")
	private double precioVenta;
	
	@Column(name="precio_interno")
	private double precioInterno;
	
	@Column(name="estado")
	private boolean estado=true;
	
	@Transient
	private MultipartFile imagen;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_categoria")
	private Categoria categoria;
	
	@OneToMany(mappedBy="producto")
	private Set<Maestra> maestras;

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public double getPrecioInterno() {
		return precioInterno;
	}

	public void setPrecioInterno(double precioInterno) {
		this.precioInterno = precioInterno;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public MultipartFile getImagen() {
		return imagen;
	}

	public void setImagen(MultipartFile imagen) {
		this.imagen = imagen;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Set<Maestra> getMaestras() {
		return maestras;
	}

	public void setMaestras(Set<Maestra> maestras) {
		this.maestras = maestras;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", descripcion="
				+ descripcion + ", detalle=" + detalle + ", stock=" + stock + ", precioVenta=" + precioVenta
				+ ", precioInterno=" + precioInterno + ", estado=" + estado + ", imagen=" + imagen + ", categoria="
				+ categoria + ", maestras=" + maestras + "]";
	}

	

}
