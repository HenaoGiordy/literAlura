package org.example.literalura;

import org.example.literalura.logica.Interaccion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
		Interaccion interaccion = new Interaccion();
		interaccion.iniciar();
	}

}
