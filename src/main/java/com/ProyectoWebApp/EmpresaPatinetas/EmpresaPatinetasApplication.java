package com.ProyectoWebApp.EmpresaPatinetas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.ProyectoWebApp.EmpresaPatinetas"})
public class EmpresaPatinetasApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpresaPatinetasApplication.class, args);
	}

}
