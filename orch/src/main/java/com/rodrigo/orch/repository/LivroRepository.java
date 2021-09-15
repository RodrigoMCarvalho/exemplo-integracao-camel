package com.rodrigo.orch.repository;

import com.rodrigo.orch.repository.response.LivroResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "livros", url = "http://localhost:9093/livros")
public interface LivroRepository {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    List<LivroResponse> retornaLivros();
}
