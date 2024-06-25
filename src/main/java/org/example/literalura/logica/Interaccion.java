package org.example.literalura.logica;


import org.example.literalura.models.Autor;
import org.example.literalura.models.Libro;
import org.example.literalura.repository.LibroRepository;
import org.example.literalura.utils.Idioma;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Component
public class Interaccion {

    private final ServiceImpl service;


    public Interaccion(ServiceImpl service) {
        this.service = service;
    }

    public void menu(){
                System.out.println("Elija una opción:");
                System.out.println("1-Buscar libro por Titulo");
                System.out.println("2-listar libros registrados");
                System.out.println("3-listar autores registrados");
                System.out.println("4-listar autores vivos en un determinado año");
                System.out.println("5-listar libros por idioma");
                System.out.println("6-salir");
    }
    public void iniciar() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            menu();
            int opcion = sc.nextInt();
            sc.nextLine();
            if(opcion == 1){
                System.out.println("Ingrese el titulo del libro: ");
                String libroBuscar = sc.nextLine();
                Libro nuevo = service.buscarLibro(libroBuscar);
                System.out.println(nuevo);
            }
            if(opcion == 2){
                System.out.println("Libros registrados: ");

                List<Libro> libros = service.buscarLibrosRegistrados();

                libros.forEach(System.out::println);
            }
            if(opcion == 3){
                System.out.println("Autores registrados: ");

                List<Autor> autores = service.buscarAutoresRegistrados();

                autores.forEach(System.out::println);
            }
            if(opcion == 4){
                System.out.println("Autores vivos en una fecha determinada: ");

                System.out.println("Ingrese el año inicial: ");
                Integer fechaInicial = sc.nextInt();
                System.out.println("Ingrese el año final: ");
                Integer fechaFinal = sc.nextInt();

                List<Autor> autoresVivos = service.autoresVivosFechaDeterminada(fechaInicial, fechaFinal);

                autoresVivos.forEach(System.out::println);
            }
            if (opcion == 5) {

                System.out.println("Libros por idioma: ");
                System.out.println("Idiomas disponibles:");
                System.out.println("EN, ES, FR, PT");

                String idioma = sc.nextLine();

                List<Libro> librosIdioma = service.buscarLibrosIdioma(Idioma.fromString(idioma));

                librosIdioma.forEach(System.out::println);

            }
            if(opcion == 6){
                isRunning = false;
            }
        }
    }
}
