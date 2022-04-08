package com.rafael.vendas.DTO;

import com.rafael.vendas.entities.Cliente;

public class RankingComprasDTO {
	public String nomeCliente;
	public double valorTotal;
	
	
	
	
	
	public RankingComprasDTO() {
		
	}
	public RankingComprasDTO(Cliente cliente, double valorTotal) {
		
		this.nomeCliente = cliente.getNome();
		this.valorTotal = valorTotal;
	}
	public RankingComprasDTO(String nomeCliente, double valorTotal) {
		this.nomeCliente = nomeCliente;
		this.valorTotal = valorTotal;
	}
	
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
