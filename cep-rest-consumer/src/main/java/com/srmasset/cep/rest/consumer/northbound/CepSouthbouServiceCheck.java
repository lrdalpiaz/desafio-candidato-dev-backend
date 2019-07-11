package com.srmasset.cep.rest.consumer.northbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.srmasset.cep.rest.consumer.domain.CepInformation;
import com.srmasset.cep.rest.consumer.southbound.CepSouthboundClient;

/**
 * HealthCheck do serviço southbound de consulta de CEP.
 * Utiliza um CEP sabidamente válido e testa o retorno do serviço.
 * @author dalpiaz
 */
@Component
public class CepSouthbouServiceCheck implements HealthIndicator {
  
    private static final String VALID_CEP = "90640002";

    @Autowired
    private CepSouthboundClient cepClient;

    @Override
    public Health health() {
        CepInformation cep = cepClient.cep(VALID_CEP);
        if (!cep.getBairro().equals("INVÁLID")) {
            return Health.down()
              .withDetail("Motivo:", "Serviço de CEP não está respondendo").build();
        }
        return Health.up().build();
    }
}