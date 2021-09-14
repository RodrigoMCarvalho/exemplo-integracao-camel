package com.rodrigo.imovel.controller;

import com.rodrigo.imovel.model.Imovel;
import com.rodrigo.imovel.service.ImovelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/imoveis")
@Slf4j
public class ImovelController {

    @Autowired
    private ImovelService imovelService;

    @GetMapping
    public ResponseEntity<List<Imovel>> getUsuarios() {
        log.info("ENDPOINT-IMOVEIS");
        return ResponseEntity.ok(imovelService.getImoveis());
    }
}
