package com.srmasset.cep.rest.consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Testa bootstrap do spring boot.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CepRestConsumerApplication.class)
public class SpringContextIntegrationTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }

}
