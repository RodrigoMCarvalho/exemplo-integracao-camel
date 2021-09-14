package com.rodrigo.livro.repository;

import com.rodrigo.livro.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
