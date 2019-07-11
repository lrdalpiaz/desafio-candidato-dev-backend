package com.srmasset.discovery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.srmasset.discovery.DiscoveryApplication;

/**
 * Testa bootstrap do spring boot.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DiscoveryApplication.class)
public class SpringContextLiveTest {

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
