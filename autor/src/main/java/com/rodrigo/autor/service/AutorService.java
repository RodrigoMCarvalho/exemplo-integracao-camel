package com.rodrigo.autor.service;

import com.rodrigo.autor.model.Autor;
import com.rodrigo.autor.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> getAutor() {
        return autorRepository.findAll();
    }
}
