package org.example.literalura.logica;

import org.example.literalura.models.Autor;
import org.example.literalura.models.Libro;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface IService {
    Libro buscarLibro(String titulo) throws IOException, InterruptedException;
    List<Libro> buscarLibrosRegistrados();
    List<Autor> buscarAutoresRegistrados();
    List<Autor> autoresVivosFechaDeterminada(LocalDate fechaInicial, LocalDate fechaFinal);
    List<Libro> buscarLibrosIdioma(String idioma);
}
