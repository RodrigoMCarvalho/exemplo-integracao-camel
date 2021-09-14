package com.rodrigo.orch.controller;

import com.rodrigo.orch.repository.response.UsuarioResponse;
import com.rodrigo.orch.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("camel")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<UsuarioResponse> getUser(){
        return usuarioService.listarUsuarios();
    }

}
