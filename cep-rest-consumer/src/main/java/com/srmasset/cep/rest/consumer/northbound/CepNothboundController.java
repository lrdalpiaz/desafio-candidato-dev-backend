package com.srmasset.cep.rest.consumer.northbound;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srmasset.cep.rest.consumer.domain.CepInformation;
import com.srmasset.cep.rest.consumer.service.CepService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping(path = "/cep")
public class CepNothboundController {
    @Autowired
    private CepService cepService;

    @GetMapping(path= "/{cep}",
            produces=MediaType.APPLICATION_JSON_VALUE)
    public CepInformation getCep(@PathVariable("cep") String cep) {
        return cepService.getCep(cep);
    }
    
    @PostMapping(path= "/reactive",
            consumes=MediaType.APPLICATION_JSON_VALUE)
    public Flux<CepInformation> getCepReactive(@RequestBody List<String> ceps) {
        String [] array = ceps.toArray(new String[ceps.size()]);
        return Flux.just(array).log().map(cep -> cepService.getCep(cep));
    }

    @PostMapping(path= "/",
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public List<CepInformation> getCep(@RequestBody List<String> ceps) {
        return ceps.stream().map(cep -> cepService.getCep(cep))
                .collect(Collectors.toList());
    }
}
