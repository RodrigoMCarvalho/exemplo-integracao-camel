package com.rodrigo.orch.camel;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Slf4j
public class ThrowExceptionProcessor implements Processor {

    @Override
    public void process(Exchange exchange) {
        var exception = new Exception("Alguém caiu!");
        exchange.setException(exception);
        log.info("------Alguém caiu! ");
    }

}
