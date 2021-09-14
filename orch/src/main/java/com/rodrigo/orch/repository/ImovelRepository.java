package com.rodrigo.orch.repository;

import com.rodrigo.orch.repository.response.ImovelResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "imoveis", url = "http://localhost:9091/imoveis")
public interface ImovelRepository {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    List<ImovelResponse> retornaImovel();
}
