package com.rodrigo.orch.camel.processor;

import com.rodrigo.orch.repository.response.UsuarioResponse;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.List;

public class AutorProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        List<UsuarioResponse> body = exchange.getIn().getBody(List.class);
        exchange.setProperty("autor", body);
        exchange.getIn().setBody(body);
    }
}
