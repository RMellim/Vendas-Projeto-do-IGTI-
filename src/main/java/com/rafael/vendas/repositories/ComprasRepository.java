package com.rafael.vendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rafael.vendas.DTO.RankingComprasDTO;
import com.rafael.vendas.entities.Compras;

public interface ComprasRepository extends JpaRepository<Compras, Integer>{

	
@Query("select new com.rafael.vendas.DTO.RankingComprasDTO(compras.cliente, SUM(compras.totalCompra)) "
		+ " FROM Compras AS compras GROUP BY compras.cliente ORDER BY SUM(compras.totalCompra) DESC")
List<RankingComprasDTO>findRanking();
}
