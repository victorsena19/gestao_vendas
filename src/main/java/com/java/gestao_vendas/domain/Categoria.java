package com.java.gestao_vendas.domain;


import java.util.List;
import java.util.Objects;

public class CategoriaEntity {
    private int id;
    private String nome;
    private String descricao;
    private List<EmpresaEntity> empresaEntity;

    public CategoriaEntity() {}

    public CategoriaEntity(int id, String nome, String descricao, List<EmpresaEntity> empresaEntity) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.empresaEntity = empresaEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<EmpresaEntity> getEmpresa() {
        return empresaEntity;
    }

    public void setEmpresa(List<EmpresaEntity> empresaEntity) {
        this.empresaEntity = empresaEntity;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", empresa=" + empresaEntity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaEntity categoriaEntity = (CategoriaEntity) o;
        return getId() == categoriaEntity.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
