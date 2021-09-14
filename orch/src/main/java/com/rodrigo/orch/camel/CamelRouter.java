package com.rodrigo.orch.camel;

import com.rodrigo.orch.repository.ImovelRepository;
import com.rodrigo.orch.repository.UsuarioRepository;
import feign.FeignException;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CamelRouter extends RouteBuilder {

    public static final String USUARIO = "direct:usuarios";
    public static final String IMOVEL = "direct:imoveis";
    public static final String USUARIOCAIU = "direct:usuarioCaiu";

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ImovelRepository imovelRepository;

    @Override
    public void configure() throws Exception {
        this.configExceptions();
        this.acessarEndpointComOpenFeignClient();
        this.imovel();
        this.usuarioCaiu();
    }

    private void configExceptions() {
        onException(FeignException.class)
                .maximumRedeliveries(2)
                .to(CamelRouter.USUARIOCAIU)
                .process(new ThrowExceptionProcessor())
                .end();
    }

    private void usuarioCaiu(){
        from(CamelRouter.USUARIOCAIU)
                .log("----> ${body}")
                .process(new ThrowExceptionProcessor())
                .log("error ->${body}")
                .end();
    }

    private void acessarEndpointComOpenFeignClient() {
        from(CamelRouter.USUARIO)
                .bean(usuarioRepository, "retornaUsuarios()")
                .log("----> ${body}")
                .process(new UsuarioProcessor())
                .log("->${body}")
                .to(CamelRouter.IMOVEL)
                .process(new ImovelProcessor())
                .log("->imovel")
                .end();
    }

    private void imovel(){
        from(CamelRouter.IMOVEL)
                .bean(imovelRepository, "retornaImovel()")
                .log("----> Imovel ${body}")
                .log("->${body}")
                .end();
    }

}