package com.sortizm.apirest.dto;

import lombok.Data;

@Data
public class ClienteDevueltoDTO {

	private long id;
	private String nombre;
	private String tlf;
	
	public ClienteDevueltoDTO(long id, String nombre, String tlf) {
		this.id = id;
		this.nombre = nombre;
		this.tlf = tlf;
	}
	
	public long getId() {
		return this.id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getTlf() { 
		return this.tlf; 
	}
	
}
