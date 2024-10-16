package com.java.gestao_vendas.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "pessoas")
public class Pessoa  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id_pessoa")
    private Long idPessoa;
    private String cnpjCpf;
    private String nomePessoa;
    private String email;
    private String telefone;
    private String dataNascimento;
    private EnderecoEntity enderecoEntity;
    private boolean fornecedor;
    private int tipoPessoa;
    private EmpresaEntity empresaEntity;

    public Pessoa() {}

    public Pessoa(Long idPessoa,
            EmpresaEntity empresaEntity,
            int tipoPessoa,
            boolean fornecedor,
            EnderecoEntity enderecoEntity,
            String dataNascimento,
            String telefone,
            String email,
            String nomePessoa,
            String cnpjCpf){
        this.empresaEntity = empresaEntity;
        this.tipoPessoa = tipoPessoa;
        this.fornecedor = fornecedor;
        this.enderecoEntity = enderecoEntity;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.nomePessoa = nomePessoa;
        this.cnpjCpf = cnpjCpf;
        this.idPessoa = idPessoa;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public EnderecoEntity getEndereco() {
        return enderecoEntity;
    }

    public void setEndereco(EnderecoEntity enderecoEntity) {
        this.enderecoEntity = enderecoEntity;
    }

    public boolean isFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(boolean fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(int tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public EmpresaEntity getEmpresa() {
        return empresaEntity;
    }

    public void setEmpresa(EmpresaEntity empresaEntity) {
        this.empresaEntity = empresaEntity;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "idPessoa=" + idPessoa +
                ", cnpjCpf='" + cnpjCpf + '\'' +
                ", nomePessoa='" + nomePessoa + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", endereco=" + enderecoEntity +
                ", fornecedor=" + fornecedor +
                ", tipoPessoa=" + tipoPessoa +
                ", empresa=" + empresaEntity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoaEntity = (Pessoa) o;
        return getIdPessoa() == pessoaEntity.getIdPessoa();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdPessoa());
    }
}
