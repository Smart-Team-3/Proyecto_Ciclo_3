package com.Proyecto_Ciclo_3.Modelo;

import com.Proyecto_Ciclo_3.Modelo.Entidades.Empleado;
import com.Proyecto_Ciclo_3.Modelo.Entidades.Empresa;
import com.Proyecto_Ciclo_3.Modelo.Entidades.MovimientoDinero;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Proyecto_Ciclo_3Aplication {

	public static void main(String[] args) {
		//SpringApplication.run(Proyecto_Ciclo_3Aplication.class, args);
		// declaramos una empresa la cual llamaremos empresax. definiremos sus atributos y podremos lleerlos.
		Empresa empresax = new Empresa(7029030);
		empresax.setNombre("Smart Team");
		empresax.setNIT("72394004");
		empresax.setDireccion("Carrera 80 # 118A-30");
		empresax.setTelefono("5807923");
		System.out.println("este es el nombre de la empresax: ");
		System.out.println(empresax.getNombre());
		System.out.println("este  es el Nit de la empresa: ");
		System.out.println(empresax.getNIT());
		System.out.println("esta es la direccion de la empresa: ");
		System.out.println(empresax.getDireccion());
		System.out.println("este  es el telefono de la empresa: ");
		System.out.println(empresax.getTelefono());
		// declaramos un Empleado el cual llamaremos empleado1. definiremos sus atributos y podremos leerlos.
		Empleado empleado1 = new Empleado();
		empleado1.setId(101722);
		empleado1.setNombre("Andy greyrat");
		empleado1.setCorreo("andy1328@gmail.com");
		empleado1.setEmpresa(empresax);
		empleado1.setRol("administrativo");
		System.out.println("este es el id de el empleado: ");
		System.out.println(empleado1.getId());
		System.out.println("este es el nombre de el empleado: ");
		System.out.println(empleado1.getNombre());
		System.out.println("este  es el correo del empleado: ");
		System.out.println(empleado1.getCorreo());
		System.out.println("esta es la empresa en la que trabaja el empleado1: ");
		System.out.println(empleado1.getEmpresa());
		System.out.println("este es el rol del empleado en dicha empresa: ");
		System.out.println(empleado1.getRol());
		// declaramos una transaccion la  cual llamaremos transaccion1. definiremos sus atributos y podremos leerlos.
		MovimientoDinero transaccion1 = new MovimientoDinero();
		transaccion1.setId(78893);
		transaccion1.setMonto(300000);
		transaccion1.setConcepto("Pago de la quincena");
		transaccion1.setUsuario(empleado1);
		System.out.println("este es el Id de la transaccion: ");
		System.out.println(transaccion1.getId());
		System.out.println("este  es el monto de la transaccion: ");
		System.out.println(transaccion1.getMonto());
		System.out.println("este es el concepto de la transaccion: ");
		System.out.println(transaccion1.getConcepto());
		System.out.println("este  es el Usuario que realizo la transaccion: ");
		System.out.println(transaccion1.getUsuario());
		// Con esto se comprueba que se puede definir cada uno de los atributos de cada clase asi como leerlos, tal y como se pedia como
		// requisito en este sprint 2.
	}
}
