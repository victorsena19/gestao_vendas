package com.java.gestao_vendas.repository;

import com.java.gestao_vendas.domain.Pedido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class PedidoRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Pedido> ListarPedidos() {
        return em.createQuery("from Pedido").getResultList();
    }

    public Pedido BuscarPedidoId(int id) {
        return em.find(Pedido.class, id);
    }

    public void SalvarPedido(Pedido pedido) {
        em.persist(pedido);
    }

    public void AlterarPedido(Pedido pedido) {
        em.merge(pedido);

    }

    public void ExcluirPedido(Long id) {
        em.remove(id);
    }

}
