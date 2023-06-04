package com.delOrigen.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.delOrigen.entity.enumModel.Categoria;

@Entity
public class Producto {

	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @GenericGenerator(name = "native", strategy = "native")
	 private Long producto_id;

	 @Column
	 private String title;
	 @Column
	 private int precio;
	 @Column
	 private Double cantidad;
	 @Column
	 private String imagen;
	 @Column
	 private Categoria categoria;
	 
	 
	public Producto(Long producto_id, String title, int precio, Double cantidad, String imagen, Categoria categoria) {
		super();
		this.producto_id = producto_id;
		this.title = title;
		this.precio = precio;
		this.cantidad = cantidad;
		this.imagen = imagen;
		this.categoria = categoria;
	}


	public Long getProducto_id() {
		return producto_id;
	}


	public void setProducto_id(Long producto_id) {
		this.producto_id = producto_id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public Double getCantidad() {
		return cantidad;
	}


	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	 
	 


}
