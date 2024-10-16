package com.java.gestao_vendas.domain;

import java.util.Objects;

public class EnderecoEntity {
    private int id;
    private String logradouro;
    private String bairro;
    private String endereco;
    private String cidade;
    private String estado;
    private String cep;

    public EnderecoEntity() {}

    public EnderecoEntity(int id,
                          String logradouro,
                          String bairro,
                          String endereco,
                          String cidade,
                          String estado ,
                          String cep){
        this.id = id;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnderecoEntity enderecoEntity = (EnderecoEntity) o;
        return getId() == enderecoEntity.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}

