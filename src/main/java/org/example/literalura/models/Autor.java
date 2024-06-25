package org.example.literalura.models;

import jakarta.persistence.*;
import org.example.literalura.dto.AutorDTO;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String nombre;
    private Integer fechaNacimiento;
    private Integer fechaFallecimiento;

    @JoinTable(
            name="relacion_autor_libro",
            joinColumns = @JoinColumn(name="autor_id"),
            inverseJoinColumns = @JoinColumn(name="libro_id")
    )
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Libro> libros;

    public Autor() {
    }

    public Autor(AutorDTO autorDTO) {
        this.nombre = autorDTO.name();
        this.fechaNacimiento = autorDTO.birth_year();
        this.fechaFallecimiento = autorDTO.death_year();
        this.libros = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(Integer fechaFallecimiento) {
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Autor{" +
                ", nombre='" + nombre + '\'' +
                "fechaFallecimiento=" + fechaFallecimiento +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
