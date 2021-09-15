package com.rodrigo.orch.controller;

import com.rodrigo.orch.repository.response.UsuarioResponse;
import com.rodrigo.orch.service.AutorService;
import com.rodrigo.orch.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("camel")
public class CamelController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    AutorService autorService;

    @GetMapping("/usuarios")
    public List<UsuarioResponse> getUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/autores")
    public List<UsuarioResponse> getAutores(){
        return autorService.listarAutores();
    }

}
