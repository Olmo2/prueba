package com.olmo.prueba.productos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.olmo.prueba.proveedor.Proveedor;

@Entity
public class Producto {

	
	@Id
	private String id;
	
	@Column
	private String nombre;
	
	@ManyToOne
	private Proveedor prov = new Proveedor();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Proveedor getProv() {
		return prov;
	}

	public void setProv(Proveedor prov) {
		this.prov = prov;
	}
	
	
	
	
	
	
}