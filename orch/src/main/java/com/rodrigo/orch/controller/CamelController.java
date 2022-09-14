package com.rodrigo.orch.controller;

import com.rodrigo.orch.repository.request.LivroRequest;
import com.rodrigo.orch.repository.response.LivroResponse;
import com.rodrigo.orch.repository.response.UsuarioResponse;
import com.rodrigo.orch.service.AutorService;
import com.rodrigo.orch.service.LivroService;
import com.rodrigo.orch.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("camel")
public class CamelController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    AutorService autorService;

    @Autowired
    LivroService livroService;

    @GetMapping("/usuarios")
    public List<UsuarioResponse> getUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/autores")
    public List<UsuarioResponse> getAutores(){
        return autorService.listarAutores();
    }

    @GetMapping("/livros")
    public List<LivroResponse> getLivros(){
        return livroService.getLivros();
    }

    @PatchMapping("/livros/atualizar")
    public void atualizarLivros(){
        livroService.atualizarLivro();
    }

    @PostMapping("/addLivro")
    public LivroResponse addLivro(@RequestBody LivroRequest livroRequest) {
        return livroService.addLivro(livroRequest);
    }

}
