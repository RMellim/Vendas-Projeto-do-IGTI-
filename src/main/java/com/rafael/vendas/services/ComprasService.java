package com.rafael.vendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.vendas.DTO.ClienteDTO;
import com.rafael.vendas.DTO.ComprasDTO;
import com.rafael.vendas.entities.Cliente;
import com.rafael.vendas.entities.Compras;
import com.rafael.vendas.repositories.ClienteRepository;
import com.rafael.vendas.repositories.ComprasRepository;

@Service
public class ComprasService {
	
	@Autowired
	private ComprasRepository comprasRepository;
	
	
	public List<ComprasDTO> findAll() {
		List<Compras>res= comprasRepository.findAll();
		return res.stream().map(c-> new ComprasDTO(c)).collect(Collectors.toList());
	}

}
