package com.rodrigo.livro.service;

import com.rodrigo.livro.model.Livro;
import com.rodrigo.livro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> getLivros() {
        return livroRepository.findAll();
    }

    public Optional<Livro> getLivroById(Long id) {
        return livroRepository.findById(id);
    }

    public Livro saveLivro(Livro livro) {
        return livroRepository.save(livro);
    }
}
