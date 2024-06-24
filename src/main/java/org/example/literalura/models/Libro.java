package org.example.literalura.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import org.example.literalura.dto.LibroDTO;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    private String idioma;

    private Integer descargas;

    @ManyToMany(mappedBy = "libros", fetch = FetchType.LAZY)
    private List<Autor> autores;

    public Libro(LibroDTO libroDTO){
        ObjectMapper mapper = new ObjectMapper();
        this.titulo = libroDTO.title();
        this.autores = new ArrayList<>();
        this.autores.addAll(libroDTO.authors().stream().map(Autor::new).toList());
        this.descargas = libroDTO.download_count();
    }

    public Libro() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getDescargas() {
        return descargas;
    }

    public void setDescargas(Integer descargas) {
        this.descargas = descargas;
    }

    @Override
    public String toString() {
        return "Libro:" +
                ", autor='" + autores + '\'' +
                ", titulo='" + titulo + '\'' +
                "descargas='" + descargas + '\'' +
                ", idioma='" + idioma + '\'';
    }
}