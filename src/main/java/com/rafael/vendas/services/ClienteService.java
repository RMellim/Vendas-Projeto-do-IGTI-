package com.rafael.vendas.services;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
	
	public Cliente saveCliente(Cliente cliente) {
		return clientRepository.save(cliente);
	}
	
	public Cliente updateCliente(Integer id, Cliente newCliente) {
		return clientRepository.findById(id).map(c-> {
			c.setNome(newCliente.getNome());
			c.setDn(newCliente.getDn());
			Cliente atualizado = clientRepository.save(c);
			return atualizado;
		}).orElse(null);
	}
	
	public void deleteCliente(Integer id) {
		try {
		if(clientRepository.findById(id)!=null) {
			clientRepository.deleteById(id);
		}
	}catch(DataIntegrityViolationException e) {
		throw new DataIntegrityViolationException("Você não pode deletar este cliente");
	}
	}

	public Cliente fromDTO(ClienteDTO clienteDTO) {
		Cliente entidade= new Cliente(0,clienteDTO.getNome(),clienteDTO.getDn());
		return entidade;
	}
	
	

}
