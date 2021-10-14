package com.sortizm.apirest.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sortizm.apirest.dto.ClienteDevueltoSinIdDTO;
import com.sortizm.apirest.dto.ClienteEnviadoDTO;
import com.sortizm.apirest.dto.ClienteListDTO;
import com.sortizm.apirest.model.Cliente;
import com.sortizm.apirest.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/")
	public ResponseEntity<ClienteListDTO> findAllClientes(){
		List<Cliente> list = this.clienteService.findAll();
		if(list == null) {
			return new ResponseEntity<ClienteListDTO>(new ClienteListDTO(true, null, "Hubo un problema en la Base de datos"), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<ClienteListDTO>(new ClienteListDTO(false, list, ""), HttpStatus.OK);
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<ClienteDevueltoSinIdDTO> newCliente(@RequestBody ClienteEnviadoDTO clienteDTO) {
		try {
		Cliente nuevoCliente = new Cliente(clienteDTO.getNombre(), clienteDTO.getTlf());
		this.clienteService.saveCliente(nuevoCliente);
		return new ResponseEntity<ClienteDevueltoSinIdDTO>(new ClienteDevueltoSinIdDTO(clienteDTO.getNombre(), clienteDTO.getTlf()), HttpStatus.CREATED);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<ClienteDevueltoSinIdDTO>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cliente>> findByIdCliente(@PathVariable("id") int id) {
		Optional<Cliente> cliente = this.clienteService.findClienteById(id);
		return cliente == null ? new ResponseEntity<Optional<Cliente>>(HttpStatus.NOT_FOUND)
							   : new ResponseEntity<Optional<Cliente>>(cliente, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable("id") int id, @RequestBody Cliente cliente) {
		try {
			Cliente nuevoCliente = this.clienteService.findClienteById(id).get();
			nuevoCliente.setNombre(cliente.getNombre());
			nuevoCliente.setTlf(cliente.getTlf());
			return new ResponseEntity<Cliente>(nuevoCliente, HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCliente(@PathVariable("id") int id) {
		try {
			this.clienteService.deleteCliente(id);
			return ResponseEntity.noContent().build();
		} catch(NoSuchElementException e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
}
