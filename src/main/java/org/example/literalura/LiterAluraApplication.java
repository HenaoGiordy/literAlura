package org.example.literalura;

import org.example.literalura.logica.Interaccion;
import org.example.literalura.logica.ServiceImpl;
import org.example.literalura.repository.AutorRepository;
import org.example.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	@Autowired
	private LibroRepository libroRepository;
	@Autowired
	private AutorRepository autorRepository;

	public static void main(String[] args)  {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Interaccion interaccion = new Interaccion(new ServiceImpl(libroRepository, autorRepository));
		try {
			interaccion.iniciar();
		}catch (Exception e){
			e.printStackTrace();
		}

	}
}
