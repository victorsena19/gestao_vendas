package com.java.gestao_vendas.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class VendedorEntity {
    private int id;
    private List<LocalDateTime> dataContratacao;
    private double comissao;
    private List<PessoaEntity> pessoaEntity;
    private List<EmpresaEntity> empresaEntity;

    public VendedorEntity() {}

    public VendedorEntity(int id,
                          List<LocalDateTime> dataContratacao,
                          double comissao,
                          List<PessoaEntity> pessoaEntity,
                          List<EmpresaEntity> empresaEntity) {
        this.id = id;
        this.dataContratacao = dataContratacao;
        this.comissao = comissao;
        this.pessoaEntity = pessoaEntity;
        this.empresaEntity = empresaEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<LocalDateTime> getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(List<LocalDateTime> dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public List<PessoaEntity> getPessoa() {
        return pessoaEntity;
    }

    public void setPessoa(List<PessoaEntity> pessoaEntity) {
        this.pessoaEntity = pessoaEntity;
    }

    public List<EmpresaEntity> getEmpresa() {
        return empresaEntity;
    }

    public void setEmpresa(List<EmpresaEntity> empresaEntity) {
        this.empresaEntity = empresaEntity;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "id=" + id +
                ", dataContratacao=" + dataContratacao +
                ", comissao=" + comissao +
                ", pessoa=" + pessoaEntity +
                ", empresa=" + empresaEntity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendedorEntity vendedorEntity = (VendedorEntity) o;
        return getId() == vendedorEntity.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
