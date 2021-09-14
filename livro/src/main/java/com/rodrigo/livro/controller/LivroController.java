package com.rodrigo.livro.controller;

import com.rodrigo.livro.model.Livro;
import com.rodrigo.livro.service.LivroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livros")
@Slf4j
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> getAutores() {
        log.info("ENDPOINT-LIVROS");
        return ResponseEntity.ok(livroService.getAutor());
    }
}
