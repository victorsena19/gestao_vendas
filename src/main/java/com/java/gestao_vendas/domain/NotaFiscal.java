package com.java.gestao_vendas.domain;

import javafx.beans.property.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class NotaFiscalEntity {
    private int idNotaFiscal;
    private String numeroNotaFiscal;
    private String chaveAcessoCupomFiscal;
    private String serieNotaFiscal;
    private List<LocalDateTime> dataEmissao;
    private String naturezaOperacao;
    private String protocolo;
    private String oservacaoNotaFiscal;
    private List<VendaEntity> vendaEntity;
    private List<EmpresaEntity> empresaEntity;

    public NotaFiscalEntity() {}

    public NotaFiscalEntity(int idNotaFiscal,
                            String numeroNotaFiscal,
                            String chaveAcessoCupomFiscal,
                            String serieNotaFiscal,
                            List<LocalDateTime> dataEmissao,
                            String naturezaOperacao,
                            String protocolo,
                            String oservacaoNotaFiscal,
                            List<VendaEntity> vendaEntity,
                            List<EmpresaEntity> empresaEntity) {
        this.idNotaFiscal = idNotaFiscal;
        this.numeroNotaFiscal = numeroNotaFiscal;
        this.chaveAcessoCupomFiscal = chaveAcessoCupomFiscal;
        this.serieNotaFiscal = serieNotaFiscal;
        this.dataEmissao = dataEmissao;
        this.naturezaOperacao = naturezaOperacao;
        this.protocolo = protocolo;
        this.oservacaoNotaFiscal = oservacaoNotaFiscal;
        this.vendaEntity = vendaEntity;
        this.empresaEntity = empresaEntity;
    }

    public int getIdNotaFiscal() {
        return idNotaFiscal;
    }

    public void setIdNotaFiscal(int idNotaFiscal) {
        this.idNotaFiscal = idNotaFiscal;
    }

    public String getNumeroNotaFiscal() {
        return numeroNotaFiscal;
    }

    public void setNumeroNotaFiscal(String numeroNotaFiscal) {
        this.numeroNotaFiscal = numeroNotaFiscal;
    }

    public String getChaveAcessoCupomFiscal() {
        return chaveAcessoCupomFiscal;
    }

    public void setChaveAcessoCupomFiscal(String chaveAcessoCupomFiscal) {
        this.chaveAcessoCupomFiscal = chaveAcessoCupomFiscal;
    }

    public String getSerieNotaFiscal() {
        return serieNotaFiscal;
    }

    public void setSerieNotaFiscal(String serieNotaFiscal) {
        this.serieNotaFiscal = serieNotaFiscal;
    }

    public List<LocalDateTime> getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(List<LocalDateTime> dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getNaturezaOperacao() {
        return naturezaOperacao;
    }

    public void setNaturezaOperacao(String naturezaOperacao) {
        this.naturezaOperacao = naturezaOperacao;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getOservacaoNotaFiscal() {
        return oservacaoNotaFiscal;
    }

    public void setOservacaoNotaFiscal(String oservacaoNotaFiscal) {
        this.oservacaoNotaFiscal = oservacaoNotaFiscal;
    }

    public List<VendaEntity> getVenda() {
        return vendaEntity;
    }

    public void setVenda(List<VendaEntity> vendaEntity) {
        this.vendaEntity = vendaEntity;
    }

    public List<EmpresaEntity> getEmpresa() {
        return empresaEntity;
    }

    public void setEmpresa(List<EmpresaEntity> empresaEntity) {
        this.empresaEntity = empresaEntity;
    }

    @Override
    public String toString() {
        return "NotaFiscal{" +
                "idNotaFiscal=" + idNotaFiscal +
                ", numeroNotaFiscal='" + numeroNotaFiscal + '\'' +
                ", chaveAcessoCupomFiscal='" + chaveAcessoCupomFiscal + '\'' +
                ", serieNotaFiscal='" + serieNotaFiscal + '\'' +
                ", dataEmissao=" + dataEmissao +
                ", naturezaOperacao='" + naturezaOperacao + '\'' +
                ", protocolo='" + protocolo + '\'' +
                ", oservacaoNotaFiscal='" + oservacaoNotaFiscal + '\'' +
                ", venda=" + vendaEntity +
                ", empresa=" + empresaEntity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotaFiscalEntity that = (NotaFiscalEntity) o;
        return getIdNotaFiscal() == that.getIdNotaFiscal();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdNotaFiscal());
    }
}
