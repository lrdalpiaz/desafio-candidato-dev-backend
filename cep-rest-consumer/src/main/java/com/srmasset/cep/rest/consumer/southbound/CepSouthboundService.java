package com.srmasset.cep.rest.consumer.southbound;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.srmasset.cep.rest.consumer.domain.CepInformation;

public interface CepSouthboundService {
    @RequestMapping(path="/orchestrator/v1/obter-endereco-por-cep/{cep}", produces=MediaType.APPLICATION_JSON_VALUE)
    CepInformation cep(@PathVariable("cep") String cep);
}
