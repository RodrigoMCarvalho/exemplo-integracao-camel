package com.rodrigo.orch.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import static org.apache.tomcat.util.net.SocketEvent.TIMEOUT;

@Repository
public class LivroV2Repository {

    @Autowired
    private RestTemplate restTemplate;

    public void atualizarLivroV2() {

        Long id = 1l;
        String nome = "Rodrigo";

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectTimeout(1000);
        requestFactory.setReadTimeout(100);

        restTemplate.setRequestFactory(requestFactory);
        restTemplate.patchForObject("http://localhost:9093/livros/atualizar/{id}/autor/{nome}",
                null, String.class, id, nome);
    }
}
