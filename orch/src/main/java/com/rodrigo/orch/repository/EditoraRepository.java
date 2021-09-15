package com.rodrigo.orch.repository;

import com.rodrigo.orch.repository.response.EditoraResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "editoras", url = "http://localhost:9095/editoras")
public interface EditoraRepository {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    List<EditoraResponse> retornaEditoras();
}
