package com.rodrigo.autor.repository;

import com.rodrigo.autor.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
