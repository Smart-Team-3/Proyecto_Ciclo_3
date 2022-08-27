package com.UdeAciclo3.modelos;

import com.UdeAciclo3.modelos.Entidades.Empresa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@SpringBootApplication
public class ModelosApplication {
	@GetMapping("/onLine")
	public String onLine(){
		return "hola ciclo3";
	}

	@GetMapping("/test")
	public String test(){
		Empresa emp= new Empresa("yopis sas","calle 10","323456","1114247");
		emp.setNombre("yopis ltda");
		System.out.println("se creó nombre la empresa y se renombró" );
		return emp.getNombre();
	}

	public static void main(String[] args) {
		SpringApplication.run(ModelosApplication.class, args);
	}

}
