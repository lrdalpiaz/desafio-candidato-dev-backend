package com.srmasset.cep.rest.consumer.cache;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalCause;
import com.github.benmanes.caffeine.cache.RemovalListener;

/**
 * Configuração de cache de serviço externo de recuperação de CEPs.
 * @author dalpiaz
 */
@Configuration
public class CacheConfiguration {

    @Value("${cep.nothbound.cache.size:50}")
    private long cacheSize;
    @Value("${cep.nothbound.cache.expireAfter:15}")
    private long cacheExpireAfter;
    @Value("${cep.nothbound.cache.expireUnit:MINUTES}")
    private String expireUnit;
    
    @Bean
    public CacheManager cacheManager(RemovalListener removalListener) {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();

        caffeineCacheManager.setCaffeine(Caffeine.newBuilder()
                .removalListener(removalListener)
                .expireAfterAccess(cacheExpireAfter, TimeUnit.valueOf(expireUnit))
                .maximumSize(cacheSize));

        return caffeineCacheManager;
    }
    
    @Bean
    public RemovalListener removalListener() {
        RemovalListener removalListener = new RemovalListener() {
            @Override
            public void onRemoval(Object key, Object value, RemovalCause cause) {
                System.out.println("Removendo " + value);
            }
        };
        return removalListener;
    }
}
