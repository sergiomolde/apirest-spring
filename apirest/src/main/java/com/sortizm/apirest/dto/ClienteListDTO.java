package com.sortizm.apirest.dto;

import java.util.List;
import com.sortizm.apirest.model.Cliente;
import lombok.Data;

@Data
public class ClienteListDTO {
	
	private Boolean errors;
	private List<Cliente> list;
	private String message;
	
	public ClienteListDTO(Boolean errors, List<Cliente> list, String message) {
		this.errors = errors;
		this.list = list;
		this.message = message;
	}

	public Boolean getErrors() {
		return errors;
	}

	public void setErrors(Boolean errors) {
		this.errors = errors;
	}

	public List<Cliente> getList() {
		return list;
	}

	public void setList(List<Cliente> list) {
		this.list = list;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
