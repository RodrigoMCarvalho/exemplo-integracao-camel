package com.rodrigo.livro.service;

import com.rodrigo.livro.model.Livro;
import com.rodrigo.livro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> getAutor() {
        return livroRepository.findAll();
    }
}
