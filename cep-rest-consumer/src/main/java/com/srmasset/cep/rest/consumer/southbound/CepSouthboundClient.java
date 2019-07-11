package com.srmasset.cep.rest.consumer.southbound;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.srmasset.cep.rest.consumer.domain.CepInformation;

@FeignClient(name = "cep-producer",
    url = "https://zuul.trusthub.com.br",
    fallback = CepSouthboundClient.CepClientFallback.class)
public interface CepSouthboundClient extends CepSouthboundService {
    @Component
    public static class CepClientFallback implements CepSouthboundClient {
        @Override
        public CepInformation cep(@PathVariable("cep") String cep) {
            CepInformation cepInformation = new CepInformation();
            cepInformation.setBairro("INVÁLIDO");
            cepInformation.setCidade("INVÁLIDO");
            cepInformation.setEstado("INVÁLIDO");
            cepInformation.setLogradouro("INVÁLIDO");
            return cepInformation;
        }
    }
}
