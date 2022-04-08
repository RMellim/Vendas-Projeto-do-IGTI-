package com.rafael.vendas.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.vendas.DTO.ComprasDTO;
import com.rafael.vendas.DTO.RankingComprasDTO;
import com.rafael.vendas.entities.Compras;
import com.rafael.vendas.services.ComprasService;

@RestController
@RequestMapping("/compras")
public class ComprasControler {

	@Autowired
	private ComprasService comprasService;
	
	@GetMapping("/ranking-cliente-por-compras")
	public ResponseEntity<List<RankingComprasDTO>>findRanking(){
		
		List<RankingComprasDTO> lista = comprasService.findRanking();
		return ResponseEntity.ok(lista);
	}

	@GetMapping
	public ResponseEntity<List<ComprasDTO>> findAll() {
		
		List<ComprasDTO> lista = comprasService.findAll();
		return ResponseEntity.ok(lista);
	}
		
	@PostMapping
	@ResponseBody
	public ResponseEntity<ComprasDTO> saveCompras(@RequestBody ComprasDTO comprasDTO){
		Compras entidade= comprasService.fromDTO(comprasDTO);
		comprasService.saveCompras(entidade);
		return new ResponseEntity<ComprasDTO>(comprasDTO, HttpStatus.CREATED);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void>deleteCompras(@PathVariable Integer id){
		comprasService.deleteCompras(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@PutMapping(path="/{id}")
	@ResponseBody
	public ResponseEntity<ComprasDTO> updateCompras(@PathVariable Integer id, @RequestBody ComprasDTO comprasDTO){
		Compras entidade= comprasService.fromDTO(comprasDTO);
		if(comprasService.updateCompras(id, entidade)!=null) {
			return new ResponseEntity<ComprasDTO>(comprasDTO, HttpStatus.CREATED);
		}
		return  ResponseEntity.notFound().build();
	}

	
}
