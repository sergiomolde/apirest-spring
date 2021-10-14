package com.sortizm.apirest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sortizm.apirest.model.Cliente;
import com.sortizm.apirest.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente saveCliente(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	public List<Cliente> findAll(){
		return this.clienteRepository.findAll();
	}
	
	public Optional<Cliente> findClienteById(long id) {
		return this.clienteRepository.findById(id);
	}
	
	public Cliente updateCliente(Cliente cliente) {
		return this.clienteRepository.save(cliente);
	}
	
	public void deleteCliente(long id) {
		this.clienteRepository.deleteById(id);
	}
	
}
