package com.sortizm.apirest.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sortizm.apirest.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	boolean deleteById(int id);
}
