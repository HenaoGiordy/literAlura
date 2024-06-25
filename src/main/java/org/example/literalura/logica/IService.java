package org.example.literalura.logica;

import org.example.literalura.models.Autor;
import org.example.literalura.models.Libro;
import org.example.literalura.utils.Idioma;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface IService {
    Libro buscarLibro(String titulo) throws IOException, InterruptedException;
    List<Libro> buscarLibrosRegistrados();
    List<Autor> buscarAutoresRegistrados();
    List<Autor> autoresVivosFechaDeterminada(Integer fechaInicial, Integer fechaFinal);
    List<Libro> buscarLibrosIdioma(Idioma idioma);
}
