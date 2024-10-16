package com.java.gestao_vendas.domain;

import com.java.gestao_vendas.enuns.Status;
import com.java.gestao_vendas.enuns.TipoPagamento;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class VendaEntity {
    private int idVenda;
    private String tipoDocumento;
    private String numeroDocumento;
    private String chaveAcesso;
    private List<Status> statusPagamento;
    private List<LocalDateTime> dataVenda;
    private double desconto;
    private double valorTotal;
    private List<TipoPagamento> tipoPagamento;
    private List<PessoaEntity> Cliente;
    private List<VendedorEntity> vendedorEntity;
    private List<VendaProdutoEntity> vendaProdutoEntity;
    private List<EmpresaEntity> empresaEntity;

    public VendaEntity() {
    }

    public VendaEntity(int idVenda, String tipoDocumento, String numeroDocumento, String chaveAcesso, List<Status> statusPagamento, List<LocalDateTime> dataVenda, double desconto, double valorTotal, List<TipoPagamento> tipoPagamento, List<PessoaEntity> cliente, List<VendedorEntity> vendedorEntity, List<VendaProdutoEntity> vendaProdutoEntity, List<EmpresaEntity> empresaEntity) {
        this.idVenda = idVenda;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.chaveAcesso = chaveAcesso;
        this.statusPagamento = statusPagamento;
        this.dataVenda = dataVenda;
        this.desconto = desconto;
        this.valorTotal = valorTotal;
        this.tipoPagamento = tipoPagamento;
        Cliente = cliente;
        this.vendedorEntity = vendedorEntity;
        this.vendaProdutoEntity = vendaProdutoEntity;
        this.empresaEntity = empresaEntity;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getChaveAcesso() {
        return chaveAcesso;
    }

    public void setChaveAcesso(String chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
    }

    public List<Status> getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(List<Status> statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public List<LocalDateTime> getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(List<LocalDateTime> dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<TipoPagamento> getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(List<TipoPagamento> tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public List<PessoaEntity> getCliente() {
        return Cliente;
    }

    public void setCliente(List<PessoaEntity> cliente) {
        Cliente = cliente;
    }

    public List<VendedorEntity> getVendedor() {
        return vendedorEntity;
    }

    public void setVendedor(List<VendedorEntity> vendedorEntity) {
        this.vendedorEntity = vendedorEntity;
    }

    public List<VendaProdutoEntity> getVendaProduto() {
        return vendaProdutoEntity;
    }

    public void setVendaProduto(List<VendaProdutoEntity> vendaProdutoEntity) {
        this.vendaProdutoEntity = vendaProdutoEntity;
    }

    public List<EmpresaEntity> getEmpresa() {
        return empresaEntity;
    }

    public void setEmpresa(List<EmpresaEntity> empresaEntity) {
        this.empresaEntity = empresaEntity;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "idVenda=" + idVenda +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                ", chaveAcesso='" + chaveAcesso + '\'' +
                ", statusPagamento=" + statusPagamento +
                ", dataVenda=" + dataVenda +
                ", desconto=" + desconto +
                ", valorTotal=" + valorTotal +
                ", tipoPagamento=" + tipoPagamento +
                ", Cliente=" + Cliente +
                ", vendedor=" + vendedorEntity +
                ", vendaProduto=" + vendaProdutoEntity +
                ", empresa=" + empresaEntity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendaEntity vendaEntity = (VendaEntity) o;
        return getIdVenda() == vendaEntity.getIdVenda();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdVenda());
    }
}

