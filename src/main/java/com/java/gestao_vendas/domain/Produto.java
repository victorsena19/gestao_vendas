package com.java.gestao_vendas.domain;

import java.util.Objects;

public class ProdutoEntity {
    private int cod;
    private String nomeProduto;
    private String descricao;
    private double preco;
    private int quantidadeEstoque;
    private double aliquotaIcms;
    private double aliquotaIpi;
    private String ncmProduto;
    private PessoaEntity fornecedor;
    private CategoriaEntity categoriaEntity;
    private EmpresaEntity empresaEntity;

    public ProdutoEntity() {}

    public ProdutoEntity(int cod,
                         String nomeProduto,
                         String descricao,
                         double preco,
                         int quantidadeEstoque,
                         double aliquotaIcms,
                         double aliquotaIpi,
                         String ncmProduto,
                         PessoaEntity fornecedor,
                         CategoriaEntity categoriaEntity,
                         EmpresaEntity empresaEntity) {
        this.cod = cod;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.aliquotaIcms = aliquotaIcms;
        this.aliquotaIpi = aliquotaIpi;
        this.ncmProduto = ncmProduto;
        this.fornecedor = fornecedor;
        this.categoriaEntity = categoriaEntity;
        this.empresaEntity = empresaEntity;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getAliquotaIcms() {
        return aliquotaIcms;
    }

    public void setAliquotaIcms(double aliquotaIcms) {
        this.aliquotaIcms = aliquotaIcms;
    }

    public double getAliquotaIpi() {
        return aliquotaIpi;
    }

    public void setAliquotaIpi(double aliquotaIpi) {
        this.aliquotaIpi = aliquotaIpi;
    }

    public String getNcmProduto() {
        return ncmProduto;
    }

    public void setNcmProduto(String ncmProduto) {
        this.ncmProduto = ncmProduto;
    }

    public PessoaEntity getFornecedores() {
        return fornecedor;
    }

    public void setFornecedor(PessoaEntity fornecedor) {
        this.fornecedor = fornecedor;
    }

    public CategoriaEntity getCategoria() {
        return categoriaEntity;
    }

    public void setCategoria(CategoriaEntity categoriaEntity) {
        this.categoriaEntity = categoriaEntity;
    }

    public EmpresaEntity getEmpresa() {
        return empresaEntity;
    }

    public void setEmpresa(EmpresaEntity empresaEntity) {
        this.empresaEntity = empresaEntity;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "cod=" + cod +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", quantidadeEstoque=" + quantidadeEstoque +
                ", aliquotaIcms=" + aliquotaIcms +
                ", aliquotaIpi=" + aliquotaIpi +
                ", ncmProduto='" + ncmProduto + '\'' +
                ", fornecedor=" + fornecedor +
                ", categoria=" + categoriaEntity +
                ", empresa=" + empresaEntity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoEntity produtoEntity = (ProdutoEntity) o;
        return getCod() == produtoEntity.getCod();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCod());
    }
}
