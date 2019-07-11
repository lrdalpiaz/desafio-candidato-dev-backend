package com.srmasset.cep.rest.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableFeignClients
@EnableEurekaClient
@EnableCaching
public class CepRestConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CepRestConsumerApplication.class, args);
    }

}
