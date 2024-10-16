package com.java.gestao_vendas.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


public class CupomFiscalEntity {
    private int idCupomFiscal;
    private String numeroCupomFiscal;
    private String chaveAcessoCupomFiscal;
    private List<LocalDateTime> dataEmissao;
    private String serie;
    private String protocolo;
    private String observacaoNotaFiscal;
    private List<VendaEntity> vendaEntityId;
    private List<EmpresaEntity> empresaEntity;

    public CupomFiscalEntity() {}

    public CupomFiscalEntity(int idCupomFiscal,
                             String numeroCupomFiscal,
                             String chaveAcessoCupomFiscal,
                             List<LocalDateTime> dataEmissao,
                             String serie,
                             String protocolo,
                             String observacaoNotaFiscal,
                             List<VendaEntity> vendaEntityId,
                             List<EmpresaEntity> empresaEntity) {
        this.idCupomFiscal = idCupomFiscal;
        this.numeroCupomFiscal = numeroCupomFiscal;
        this.chaveAcessoCupomFiscal = chaveAcessoCupomFiscal;
        this.dataEmissao = dataEmissao;
        this.serie = serie;
        this.protocolo = protocolo;
        this.observacaoNotaFiscal = observacaoNotaFiscal;
        this.vendaEntityId = vendaEntityId;
        this.empresaEntity = empresaEntity;
    }

    public int getIdCupomFiscal() {
        return idCupomFiscal;
    }

    public void setIdCupomFiscal(int idCupomFiscal) {
        this.idCupomFiscal = idCupomFiscal;
    }

    public String getNumeroCupomFiscal() {
        return numeroCupomFiscal;
    }

    public void setNumeroCupomFiscal(String numeroCupomFiscal) {
        this.numeroCupomFiscal = numeroCupomFiscal;
    }

    public String getChaveAcessoCupomFiscal() {
        return chaveAcessoCupomFiscal;
    }

    public void setChaveAcessoCupomFiscal(String chaveAcessoCupomFiscal) {
        this.chaveAcessoCupomFiscal = chaveAcessoCupomFiscal;
    }

    public List<LocalDateTime> getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(List<LocalDateTime> dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getObservacaoNotaFiscal() {
        return observacaoNotaFiscal;
    }

    public void setObservacaoNotaFiscal(String observacaoNotaFiscal) {
        this.observacaoNotaFiscal = observacaoNotaFiscal;
    }

    public List<VendaEntity> getVendaId() {
        return vendaEntityId;
    }

    public void setVendaId(List<VendaEntity> vendaEntityId) {
        this.vendaEntityId = vendaEntityId;
    }

    public List<EmpresaEntity> getEmpresa() {
        return empresaEntity;
    }

    public void setEmpresa(List<EmpresaEntity> empresaEntity) {
        this.empresaEntity = empresaEntity;
    }

    @Override
    public String toString() {
        return "CupomFiscal{" +
                "idCupomFiscal=" + idCupomFiscal +
                ", numeroCupomFiscal='" + numeroCupomFiscal + '\'' +
                ", chaveAcessoCupomFiscal='" + chaveAcessoCupomFiscal + '\'' +
                ", dataEmissao=" + dataEmissao +
                ", serie='" + serie + '\'' +
                ", protocolo='" + protocolo + '\'' +
                ", observacaoNotaFiscal='" + observacaoNotaFiscal + '\'' +
                ", vendaId=" + vendaEntityId +
                ", empresa=" + empresaEntity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CupomFiscalEntity that = (CupomFiscalEntity) o;
        return getIdCupomFiscal() == that.getIdCupomFiscal();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getIdCupomFiscal());
    }
}
