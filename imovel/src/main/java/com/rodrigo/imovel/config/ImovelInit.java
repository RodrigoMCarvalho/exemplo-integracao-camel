package com.rodrigo.imovel.config;

import com.rodrigo.imovel.model.Imovel;
import com.rodrigo.imovel.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ImovelInit implements ApplicationRunner {

    @Autowired
    private ImovelRepository imovelRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Imovel imovel1 = Imovel.builder().descricao("Apartamento A").usuarioId(1L).build();
        Imovel imovel2 = Imovel.builder().descricao("Apartamento B").usuarioId(1L).build();
        Imovel imovel3 = Imovel.builder().descricao("Apartamento C").usuarioId(2L).build();
        imovelRepository.save(imovel1);
        imovelRepository.save(imovel2);
        imovelRepository.save(imovel3);
    }
}
