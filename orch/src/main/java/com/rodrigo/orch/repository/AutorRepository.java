package com.rodrigo.orch.repository;

import com.rodrigo.orch.repository.response.AutorResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "autores", url = "http://localhost:9092/autores")
public interface AutorRepository {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    List<AutorResponse> retornaAutores();
}
