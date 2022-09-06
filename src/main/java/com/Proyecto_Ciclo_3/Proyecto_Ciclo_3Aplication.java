package com.Proyecto_Ciclo_3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"Proyecto_Ciclo_3"})
public class Proyecto_Ciclo_3Aplication {
	public static void main(String[] args) {
		SpringApplication.run(Proyecto_Ciclo_3Aplication.class, args);
	}

}
