package com.rodrigo.editora.controller;

import com.rodrigo.editora.model.Editora;
import com.rodrigo.editora.service.EditoraService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/editoras")
@Slf4j
public class EditaraController {

    @Autowired
    private EditoraService editoraService;

    @GetMapping
    public ResponseEntity<List<Editora>> getAutores() {
        log.info("ENDPOINT-EDITORA");
        return ResponseEntity.ok(editoraService.getEditoras());
    }
}
