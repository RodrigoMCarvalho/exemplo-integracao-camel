package com.rodrigo.orch.camel.route;

import com.rodrigo.orch.camel.processor.*;
import com.rodrigo.orch.repository.AutorRepository;
import com.rodrigo.orch.repository.ImovelRepository;
import com.rodrigo.orch.repository.LivroRepository;
import com.rodrigo.orch.repository.UsuarioRepository;
import feign.FeignException;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CamelRouter extends RouteBuilder {

    public static final String USUARIO = "direct:usuarios";
    public static final String IMOVEL = "direct:imoveis";
    public static final String AUTOR = "direct:autores";
    public static final String LIVRO = "direct:livros";
    public static final String USUARIOCAIU = "direct:usuarioCaiu";

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ImovelRepository imovelRepository;

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    LivroRepository livroRepository;

    @Override
    public void configure() throws Exception {
        this.configExceptions();
        this.acessarEndpointComOpenFeignClient();
        this.imovel();
        this.autor();
        this.livros();
        this.usuarioCaiu();
    }

    private void configExceptions() {
        onException(FeignException.class)
                .maximumRedeliveries(2)
            .to(USUARIOCAIU)
                .process(new ThrowExceptionProcessor())
                .end();
    }

    private void usuarioCaiu(){
        from(USUARIOCAIU)
                .log("----> ${body}")
                .process(new ThrowExceptionProcessor())
                .log("error ->${body}")
            .end();
    }

    private void acessarEndpointComOpenFeignClient() {
        from(USUARIO)
                .bean(usuarioRepository, "retornaUsuarios()")
                .log("----> ${body}")
                .process(new UsuarioProcessor())
                .log("->${body}")
            .to(IMOVEL)
                .process(new ImovelProcessor())
                .log("->imovel")
            .end();
    }

    private void imovel(){
        from(IMOVEL)
                .bean(imovelRepository, "retornaImovel()")
                .log("----> Imovel ${body}")
                .log("->${body}")
            .end();
    }

    private void autor(){
        from(AUTOR)
                .bean(autorRepository, "retornaAutores()")
                .process(new AutorProcessor())
            .to(LIVRO)
                .process(new LivroProcessor())
            .end();
    }

    private void livros(){
        from(LIVRO)
                .bean(livroRepository, "retornaLivros()")
            .end();
    }

}