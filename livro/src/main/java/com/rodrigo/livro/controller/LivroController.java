package com.rodrigo.livro.controller;

import com.rodrigo.livro.model.Livro;
import com.rodrigo.livro.service.LivroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/livros")
@Slf4j
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> getLivros() {
        return ResponseEntity.ok(livroService.getLivros());
    }

    @GetMapping("/id")
    public ResponseEntity<Livro> getLivroById(@PathVariable Long id) {
        return livroService.getLivroById(id)
                .map(livro -> ResponseEntity.ok(livro))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity saveLivro(@RequestBody Livro livro) {
        Livro livroSalvo = livroService.saveLivro(livro);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(livroSalvo.getId())
                .toUri();
        return ResponseEntity.created(uri).body(livroSalvo);
    }

    @PatchMapping("/atualizar/{id}/autor/{nome}")
    public ResponseEntity atualizarLivro(@PathVariable Long id, @PathVariable String nome) {
        log.info("id= {}, autor= {}", id, nome);
        return ResponseEntity.ok().build();
    }
}
