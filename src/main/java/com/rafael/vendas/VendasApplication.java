package com.rafael.vendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafael.vendas.repositories.ClienteRepository;

@SpringBootApplication
public class VendasApplication {

	public static void main(String[] args) {
		
		
		ClienteRepository testRepository;
		
		SpringApplication.run(VendasApplication.class, args);
	}

}
