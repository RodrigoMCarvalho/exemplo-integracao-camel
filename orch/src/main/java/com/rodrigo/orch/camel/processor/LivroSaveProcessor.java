package com.rodrigo.orch.camel.processor;

import com.rodrigo.orch.repository.response.LivroResponse;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class LivroSaveProcessor implements Processor {

    @Override
    public void process(Exchange exchange) {
        LivroResponse body = exchange.getIn().getBody(LivroResponse.class);
        exchange.setProperty("livroSaved", body);
        exchange.getIn().setBody(body);
    }
}
