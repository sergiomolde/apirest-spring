package com.sortizm.apirest.dto;

public class ClienteDevueltoSinIdDTO {

	private String nombre;
	private String tlf;
	
	public ClienteDevueltoSinIdDTO(String nombre, String tlf) {
		this.nombre = nombre;
		this.tlf = tlf;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getTlf() { 
		return this.tlf; 
	}

}
