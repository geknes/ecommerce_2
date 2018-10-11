package com.hackmonkey.ecommerce.entity;

public class Maestra {
	
	private String codigo_tabla;
	private String codigo_registro;
	private String nombre_corto;
	private String nombre_largo;
	private String estado;
	private String orden;
	private String valor1;
	private String valor2;
	private String valor3;
	private String valor4;
	private String valor5;
	private String sweditable;
	
	
	public Maestra() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCodigo_tabla() {
		return codigo_tabla;
	}
	public void setCodigo_tabla(String codigo_tabla) {
		this.codigo_tabla = codigo_tabla;
	}
	public String getCodigo_registro() {
		return codigo_registro;
	}
	public void setCodigo_registro(String codigo_registro) {
		this.codigo_registro = codigo_registro;
	}
	public String getNombre_corto() {
		return nombre_corto;
	}
	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}
	public String getNombre_largo() {
		return nombre_largo;
	}
	public void setNombre_largo(String nombre_largo) {
		this.nombre_largo = nombre_largo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getOrden() {
		return orden;
	}
	public void setOrden(String orden) {
		this.orden = orden;
	}
	public String getValor1() {
		return valor1;
	}
	public void setValor1(String valor1) {
		this.valor1 = valor1;
	}
	public String getValor2() {
		return valor2;
	}
	public void setValor2(String valor2) {
		this.valor2 = valor2;
	}
	public String getValor3() {
		return valor3;
	}
	public void setValor3(String valor3) {
		this.valor3 = valor3;
	}
	public String getValor4() {
		return valor4;
	}
	public void setValor4(String valor4) {
		this.valor4 = valor4;
	}
	public String getValor5() {
		return valor5;
	}
	public void setValor5(String valor5) {
		this.valor5 = valor5;
	}
	public String getSweditable() {
		return sweditable;
	}
	public void setSweditable(String sweditable) {
		this.sweditable = sweditable;
	}
	@Override
	public String toString() {
		return "Maestra [codigo_tabla=" + codigo_tabla + ", codigo_registro=" + codigo_registro + ", nombre_corto="
				+ nombre_corto + ", nombre_largo=" + nombre_largo + ", estado=" + estado + ", orden=" + orden
				+ ", valor1=" + valor1 + ", valor2=" + valor2 + ", valor3=" + valor3 + ", valor4=" + valor4
				+ ", valor5=" + valor5 + ", sweditable=" + sweditable + "]";
	}
	
	
}
