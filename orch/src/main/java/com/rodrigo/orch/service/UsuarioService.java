package com.rodrigo.orch.service;

import com.rodrigo.orch.camel.CamelRouter;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private ProducerTemplate producerTemplate;

    public List listarUsuarios() {
        return producerTemplate.requestBody(CamelRouter.USUARIO, null, List.class);
    }
}
