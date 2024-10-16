package com.java.gestao_vendas.domain;

import com.java.gestao_vendas.enuns.Status;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id_pedido")
    private Long idPedido;

    @JoinColumn(name = "produto")
    private String produto;

    @JoinColumn(name = "quantidade")
    private int quantidade;

    @JoinColumn(name = "pessoa_id")
    private List<PessoaEntity> pessoaSolicitou;
    private List<VendedorEntity> vendedor;
    private List<LocalDateTime> dataPedido;
    private List<Status> statusPagamento;
    private List<EmpresaEntity> empresa;

    public Pedido() {}

    public Pedido(Long idPedido,
                        String produto,
                        int quantidade,
                        List<PessoaEntity> pessoaEntitySolicitou,
                        List<VendedorEntity> vendedorEntity,
                        List<LocalDateTime> dataPedido,
                        List<Status> statusPagamento,
                        List<EmpresaEntity> empresaEntity) {
        this.idPedido = idPedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.pessoaSolicitou = pessoaEntitySolicitou;
        this.vendedor = vendedorEntity;
        this.dataPedido = dataPedido;
        this.statusPagamento = statusPagamento;
        this.empresa = empresaEntity;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public List<PessoaEntity> getPessoaSolicitou() {
        return pessoaSolicitou;
    }

    public void setPessoaSolicitou(List<PessoaEntity> pessoaEntitySolicitou) {
        this.pessoaSolicitou = pessoaEntitySolicitou;
    }

    public List<VendedorEntity> getVendedor() {
        return vendedor;
    }

    public void setVendedor(List<VendedorEntity> vendedorEntity) {
        this.vendedor = vendedorEntity;
    }

    public List<LocalDateTime> getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(List<LocalDateTime> dataPedido) {
        this.dataPedido = dataPedido;
    }

    public List<Status> getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(List<Status> statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public List<EmpresaEntity> getEmpresa() {
        return empresa;
    }

    public void setEmpresa(List<EmpresaEntity> empresaEntity) {
        this.empresa = empresaEntity;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                ", produto='" + produto + '\'' +
                ", quantidade=" + quantidade +
                ", pessoaSolicitou=" + pessoaSolicitou +
                ", vendedor=" + vendedor +
                ", dataPedido=" + dataPedido +
                ", statusPagamento=" + statusPagamento +
                ", empresa=" + empresa +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedidoEntity = (Pedido) o;
        return getIdPedido() == pedidoEntity.getIdPedido();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdPedido());
    }
}
