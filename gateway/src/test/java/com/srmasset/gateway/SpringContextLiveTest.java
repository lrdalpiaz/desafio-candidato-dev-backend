package com.srmasset.gateway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Testa bootstrap do spring boot.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GatewayApplication.class)
public class SpringContextLiveTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
