package com.srmasset.cep.rest.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.srmasset.cep.rest.consumer.domain.CepInformation;
import com.srmasset.cep.rest.consumer.southbound.CepSouthboundClient;

@Component
@Cacheable
public class CepService {

    @Autowired
    public CepSouthboundClient cepClient;

    @Cacheable(value = "CEP_CACHE")
    public CepInformation getCep(String cep) {
        return cepClient.cep(cep);
    }
}
