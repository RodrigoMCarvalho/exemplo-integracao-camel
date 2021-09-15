package com.rodrigo.orch.camel.processor;

import com.rodrigo.orch.repository.response.AutorResponse;
import com.rodrigo.orch.repository.response.LivroResponse;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.List;
import java.util.stream.Collectors;

public class LivroProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        List<AutorResponse> body = exchange.getProperty("autor", List.class);
        List<LivroResponse> livros = exchange.getIn().getBody(List.class);
        body.forEach(autorResponse ->
            autorResponse.setLivros(livros.stream()
                        .filter(livroResponse -> livroResponse.getAutorId().equals(autorResponse.getId()))
                        .collect(Collectors.toList())));

        exchange.setProperty("livro", body);
        exchange.getIn().setBody(body);
    }
}
