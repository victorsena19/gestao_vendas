package com.java.gestao_vendas.domain;

import java.util.List;
import java.util.Objects;


public class EmpresaEntity {
    int idEmpresa;
    String nomeEmpresa;
    String cnpj;
    String telefone;
    List<EnderecoEntity> enderecoEntity;

    public EmpresaEntity() {}

    public EmpresaEntity(int idEmpresa, String nomeEmpresa, String cnpj, String telefone) {
        this.idEmpresa = idEmpresa;
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
        this.telefone = telefone;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<EnderecoEntity> getEndereco() {
        return enderecoEntity;
    }

    public void setEndereco(List<EnderecoEntity> enderecoEntity) {
        this.enderecoEntity = enderecoEntity;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "idEmpresa=" + idEmpresa +
                ", nomeEmpresa='" + nomeEmpresa + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco=" + enderecoEntity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpresaEntity empresaEntity = (EmpresaEntity) o;
        return getIdEmpresa() == empresaEntity.getIdEmpresa();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdEmpresa());
    }
}
