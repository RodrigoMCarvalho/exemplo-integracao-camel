package com.rodrigo.editora.service;

import com.rodrigo.editora.model.Editora;
import com.rodrigo.editora.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditoraService {

    @Autowired
    private EditoraRepository editoraRepository;

    public List<Editora> getEditoras() {
        return editoraRepository.findAll();
    }
}
