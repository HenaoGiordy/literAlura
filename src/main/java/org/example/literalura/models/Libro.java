package org.example.literalura.models;

import jakarta.persistence.*;
import org.example.literalura.dto.LibroDTO;
import org.example.literalura.utils.Idioma;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String titulo;

    private Integer descargas;

    @Enumerated(EnumType.STRING)
    private List<Idioma> idiomas;

    @ManyToMany(mappedBy = "libros", fetch = FetchType.EAGER)
    private List<Autor> autores;

    public Libro(LibroDTO libroDTO){
        this.titulo = libroDTO.title();
        this.autores = new ArrayList<>();
        this.autores.addAll(libroDTO.authors().stream().map(Autor::new).toList());
        this.idiomas = new ArrayList<>();
        libroDTO.languages().forEach(x ->{this.idiomas.add(Idioma.fromString(x));});
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


    public Integer getDescargas() {
        return descargas;
    }

    public void setDescargas(Integer descargas) {
        this.descargas = descargas;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<Idioma> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<Idioma> idiomas) {
        this.idiomas = idiomas;
    }

    @Override
    public String toString() {
        return "Libro:" +
                "titulo=" + titulo + '\n' +
                "descargas=" + descargas + '\n' +
                "idioma=" + idiomas + '\n'+
                "autores=" + autores + '\''
                ;
    }
}