package com.rafael.vendas.DTO;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.rafael.vendas.entities.Cliente;
import com.rafael.vendas.entities.Compras;

public class ComprasDTO {

	private int id;
	private Double totalCompra;
	private LocalDate dataCompra;
	
public ComprasDTO(Compras entidade) {
		
		this.id = entidade.getId();
		this.totalCompra = entidade.getTotalCompra();
		this.dataCompra = entidade.getDataCompra();
	}
	
	public ComprasDTO(int id, Double totalCompra, LocalDate dataCompra) {
		
		this.id = id;
		this.totalCompra = totalCompra;
		this.dataCompra = dataCompra;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Double getTotalCompra() {
		return totalCompra;
	}
	public void setTotalCompra(Double totalCompra) {
		this.totalCompra = totalCompra;
	}
	public LocalDate getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}
	
	
	

}
