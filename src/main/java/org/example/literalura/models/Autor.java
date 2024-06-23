package org.example.literalura.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private LocalDate fechaNacimiento;
    private LocalDate fechaFallecimiento;

    @JoinTable(
            name="relacion_autor_libro",
            joinColumns = @JoinColumn(name="autor_id"),
            inverseJoinColumns = @JoinColumn(name="libro_id")
    )
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Libro> libros;

    public Autor() {
    }

    public Autor(String nombre, LocalDate fechaNacimiento, LocalDate fechaFallecimiento) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaFallecimiento = fechaFallecimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaFallecimiento() {
        return fechaFallecimiento;
    }

    public void setFechaFallecimiento(LocalDate fechaFallecimiento) {
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
                ", libros=" + libros +
                '}';
    }
}
