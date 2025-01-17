package com.srmasset.cep.rest.consumer.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class CepInformation {

    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    
    public CepInformation() {
        // TODO Auto-generated constructor stub
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
}
