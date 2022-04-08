package com.rafael.vendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.rafael.vendas.DTO.ClienteDTO;
import com.rafael.vendas.DTO.ComprasDTO;
import com.rafael.vendas.DTO.RankingComprasDTO;
import com.rafael.vendas.entities.Cliente;
import com.rafael.vendas.entities.Compras;
import com.rafael.vendas.repositories.ClienteRepository;
import com.rafael.vendas.repositories.ComprasRepository;

@Service
public class ComprasService {
	
	@Autowired
	private ComprasRepository comprasRepository;
	

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<RankingComprasDTO> findRanking(){
		
		List<RankingComprasDTO>res= comprasRepository.findRanking();
		return res;
	}
	
	public List<RankingComprasDTO> RankingComprasDTO() {
		
		List<RankingComprasDTO>res= comprasRepository.findRanking();
		return res;
	}
	
	public List<ComprasDTO> findAll() {
		clienteRepository.findAll();
		List<Compras>res= comprasRepository.findAll();
		return res.stream().map(c-> new ComprasDTO(c)).collect(Collectors.toList());
	}
	
	public Compras saveCompras(Compras compras) {
		return comprasRepository.save(compras);
	}


	
	public void deleteCompras(Integer id) {
		try {
		if(comprasRepository.findById(id)!=null) {
			comprasRepository.deleteById(id);
		}
	}catch(DataIntegrityViolationException e) {
		throw new DataIntegrityViolationException("Você não pode deletar este cliente");
	}
	}

	public Cliente fromDTO(ClienteDTO clienteDTO) {
		Cliente entidade= new Cliente(0,clienteDTO.getNome(),clienteDTO.getDn());
		return entidade;
	}



	public Compras updateCompras(Integer id, Compras newCompras) {
		return comprasRepository.findById(id).map(c-> {
			c.setTotalCompra(newCompras.getTotalCompra());
			c.setDataCompra(newCompras.getDataCompra());
			Compras atualizado = comprasRepository.save(c);
			return atualizado;
		}).orElse(null);
	}
	
	
	public Compras fromDTO(ComprasDTO comprasDTO) {
		Compras entidade= new Compras(0,comprasDTO.getTotalCompra(),comprasDTO.getDataCompra(),
				new Cliente(comprasDTO.getCliente().getId(),null,null));
		return entidade;
	}

}
