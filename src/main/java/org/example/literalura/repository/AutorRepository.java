package org.example.literalura.repository;

import org.example.literalura.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
    Autor findByNombre(String nombre);

    List<Autor> findByFechaNacimientoBetween(Integer fechaNacimiento, Integer fechaFallecimiento);
}
