package com.rodrigo.orch.camel.processor;

import com.rodrigo.orch.repository.response.EditoraResponse;
import com.rodrigo.orch.repository.response.LivroResponse;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.List;

public class EditoraProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        List<LivroResponse> body = exchange.getProperty("livro", List.class);
        List<EditoraResponse> editoras = exchange.getIn().getBody(List.class);

        body.forEach(livro -> {
                editoras.stream()
                        .filter(editora -> livro.getEditoraId().equals(editora.getId()))
                        .forEach(editora -> livro.setEditora(editora.getNome()));
        });

        exchange.setProperty("editora", editoras);
        exchange.getIn().setBody(body);
    }
}
