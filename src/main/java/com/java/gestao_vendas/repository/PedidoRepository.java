package com.java.gestao_vendas.repository;

import com.java.gestao_vendas.domain.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class ProdutoRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Produto> ListarProdutos() {
        return em.createQuery("from Produto").getResultList();
    }

    public Produto BuscarProdutoId(int id) {
        return em.find(Produto.class, id);
    }

    public void SalvarProduto(Produto produto) {
        em.persist(produto);
    }

    public void AlterarProduto(Produto produto) {
        em.merge(produto);

    }

    public void ExcluirProduto(Long id) {
        em.remove(id);
    }

}
