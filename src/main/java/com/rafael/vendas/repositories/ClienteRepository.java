package com.rafael.vendas.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.vendas.entities.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	

}
