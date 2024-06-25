package org.example.literalura.repository;

import org.example.literalura.models.Libro;
import org.example.literalura.utils.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
    Optional<Libro> findByTitulo(String titulo);

    @Query("SELECT l FROM Libro l WHERE :idioma IN elements(l.idiomas)")
    List<Libro> findByIdiomas(@Param("idioma") Idioma idioma);


}
