package com.sortizm.apirest.dto;


public class ClienteEnviadoDTO {
	
	private String nombre;
	private String tlf;
	
	public ClienteEnviadoDTO(String nombre, String tlf) {
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
