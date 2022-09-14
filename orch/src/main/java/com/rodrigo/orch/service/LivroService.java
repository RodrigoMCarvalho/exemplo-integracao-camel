package com.rodrigo.orch.service;

import com.rodrigo.orch.camel.route.CamelRouter;
import com.rodrigo.orch.repository.LivroV2Repository;
import com.rodrigo.orch.repository.request.LivroRequest;
import com.rodrigo.orch.repository.response.LivroResponse;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private LivroV2Repository livroV2Repository;

    public LivroResponse addLivro(LivroRequest livroRequest) {
        return producerTemplate.requestBody(CamelRouter.SAVE_LIVRO, livroRequest, LivroResponse.class);
    }

    public List<LivroResponse> getLivros() {
        return producerTemplate.requestBody(CamelRouter.LIVRO, null, List.class);
    }

    public void atualizarLivro() {
        livroV2Repository.atualizarLivroV2();
    }
}
