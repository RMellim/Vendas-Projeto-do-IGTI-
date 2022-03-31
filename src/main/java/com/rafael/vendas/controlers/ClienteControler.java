package com.rafael.vendas.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.vendas.DTO.ClienteDTO;
import com.rafael.vendas.entities.Cliente;
import com.rafael.vendas.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteControler {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll() {
		
		List<ClienteDTO> lista = clienteService.findAll();
		return ResponseEntity.ok(lista);
	}

}
