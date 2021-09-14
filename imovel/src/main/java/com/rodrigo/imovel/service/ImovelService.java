package com.rodrigo.imovel.service;

import com.rodrigo.imovel.model.Imovel;
import com.rodrigo.imovel.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository imovelRepository;

    public List<Imovel> getImoveis() {
        return imovelRepository.findAll();
    }
}
