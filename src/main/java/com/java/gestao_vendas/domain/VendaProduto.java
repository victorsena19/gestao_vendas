package com.java.gestao_vendas.domain;

import java.util.Objects;

public class VendaProdutoEntity {
    private int id;
    private ProdutoEntity produtoEntity;
    private VendaEntity vendaEntity;
    private int quantidade;
    private double valorTotalProduto;
    private EmpresaEntity empresaEntity;

    public VendaProdutoEntity() {}

    public VendaProdutoEntity(int id,
                              ProdutoEntity produtoEntity,
                              VendaEntity vendaEntity,
                              int quantidade,
                              double valorTotalProduto,
                              EmpresaEntity empresaEntity) {
        this.id = id;
        this.produtoEntity = produtoEntity;
        this.vendaEntity = vendaEntity;
        this.quantidade = quantidade;
        this.valorTotalProduto = valorTotalProduto;
        this.empresaEntity = empresaEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProdutoEntity getProduto() {
        return produtoEntity;
    }

    public void setProduto(ProdutoEntity produtoEntity) {
        this.produtoEntity = produtoEntity;
    }

    public VendaEntity getVenda() {
        return vendaEntity;
    }

    public void setVenda(VendaEntity vendaEntity) {
        this.vendaEntity = vendaEntity;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotalProduto() {
        return valorTotalProduto;
    }

    public void setValorTotalProduto(double valorTotalProduto) {
        this.valorTotalProduto = valorTotalProduto;
    }

    public EmpresaEntity getEmpresa() {
        return empresaEntity;
    }

    public void setEmpresa(EmpresaEntity empresaEntity) {
        this.empresaEntity = empresaEntity;
    }

    @Override
    public String toString() {
        return "VendaProduto{" +
                "id=" + id +
                ", produto=" + produtoEntity +
                ", venda=" + vendaEntity +
                ", quantidade=" + quantidade +
                ", valorTotalProduto=" + valorTotalProduto +
                ", empresa=" + empresaEntity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendaProdutoEntity that = (VendaProdutoEntity) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
