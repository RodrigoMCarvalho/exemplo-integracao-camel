package com.rodrigo.autor.controller;

import com.rodrigo.autor.model.Autor;
import com.rodrigo.autor.service.AutorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/autores")
@Slf4j
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<Autor>> getAutores() {
        log.info("ENDPOINT-AUTORES");
        return ResponseEntity.ok(autorService.getAutor());
    }
}
