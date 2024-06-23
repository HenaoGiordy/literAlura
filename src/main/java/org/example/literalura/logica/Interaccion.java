package org.example.literalura.logica;

import java.util.Scanner;

public class Interaccion {

    public Interaccion() {}

    public void menu(){
                System.out.println("Elija una opción:");
                System.out.println("1-Buscar libro por Titulo");
                System.out.println("2-listar libros registrados");
                System.out.println("3-listar autores registrados");
                System.out.println("4-listar autores vivos en un determinado año");
                System.out.println("5-listar libros por idioma");
                System.out.println("6-salir");
    }
    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            menu();
            int opcion = sc.nextInt();
            if(opcion == 6){
                isRunning = false;
            }
        }
    }
}
