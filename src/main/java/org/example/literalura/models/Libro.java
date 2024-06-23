package org.example.literalura.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    private String autor;

    private String idioma;

    private String descargas;

    @ManyToMany(mappedBy = "libros")
    private List<Autor> autores;

    public Libro(Integer id, String titulo, String autor, String idioma, String descargas) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.descargas = descargas;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getDescargas() {
        return descargas;
    }

    public void setDescargas(String descargas) {
        this.descargas = descargas;
    }

    @Override
    public String toString() {
        return "Libro:" +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                "descargas='" + descargas + '\'' +
                ", idioma='" + idioma + '\'';
    }
}