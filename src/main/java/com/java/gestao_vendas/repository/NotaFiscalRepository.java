package com.java.gestao_vendas.repository;

import com.java.gestao_vendas.domain.CupomFiscal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class CupomFiscalRepository {

    @PersistenceContext
    private EntityManager em;

    public List<CupomFiscal> ListarCupomfiscals() {
        return em.createQuery("from CupomFiscal").getResultList();
    }

    public CupomFiscal BuscarCupomfiscalId(int id) {
        return em.find(CupomFiscal.class, id);
    }

    public void SalvarCupomfiscal(CupomFiscal cupomfiscal) {
        em.persist(cupomfiscal);
    }

    public void AlterarCupomfiscal(CupomFiscal cupomfiscal) {
        em.merge(cupomfiscal);

    }

    public void ExcluirCupomfiscal(Long id) {
        em.remove(id);
    }

}
