package com.rodrigo.orch.service;

import com.rodrigo.orch.camel.route.CamelRouter;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private ProducerTemplate producerTemplate;

    public List listarAutores() {
        return producerTemplate.requestBody(CamelRouter.AUTOR, null, List.class);
    }
}
