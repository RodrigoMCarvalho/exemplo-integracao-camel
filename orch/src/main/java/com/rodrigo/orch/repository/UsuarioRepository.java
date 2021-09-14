package com.rodrigo.orch.repository;

import com.rodrigo.orch.repository.response.UsuarioResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "usuarios", url = "http://localhost:9090/usuarios")
public interface UsuarioRepository {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    List<UsuarioResponse> retornaUsuarios();
}