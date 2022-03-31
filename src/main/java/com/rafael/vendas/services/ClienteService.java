package com.rafael.vendas.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.vendas.DTO.ClienteDTO;
import com.rafael.vendas.entities.Cliente;
import com.rafael.vendas.repositories.ClienteRepository;

@Service
public class ClienteService  {
	
	@Autowired
	private ClienteRepository clientRepository;
	
	
	public List<ClienteDTO> findAll() {
		List<Cliente>res= clientRepository.findAll();
		return res.stream().map(c-> new ClienteDTO(c)).collect(Collectors.toList());
	}


}
