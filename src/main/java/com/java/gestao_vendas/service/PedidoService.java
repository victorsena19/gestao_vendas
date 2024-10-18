package com.java.gestao_vendas.service;

import com.java.gestao_vendas.domain.DTO.PedidoDTO;
import com.java.gestao_vendas.domain.entity.Pedido;
import com.java.gestao_vendas.mapper.PedidoMapper;
import com.java.gestao_vendas.mapper.PedidoMapper;
import com.java.gestao_vendas.repository.PedidoRepository;
import com.java.gestao_vendas.repository.PedidoRepository;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {
    private final PedidoMapper pedidoMapper;
    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoMapper pedidoMapper, PedidoRepository pedidoRepository){
        this.pedidoMapper = pedidoMapper;
        this.pedidoRepository = pedidoRepository;
    }

    public PedidoDTO salvarPedido(PedidoDTO pedidoDTO){
        Pedido novoPedido = pedidoMapper.toEntity(pedidoDTO);
        Pedido pedido = pedidoRepository.save(novoPedido);
        return pedidoMapper.toDTO(pedido);
    }

    public Messege deletarPedido(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if (pedido.isPresent()) {
            pedidoRepository.delete(pedido.get());
            return new Messege("OK!", "Pedido excluido com sucesso!");
        }else{
            return new Messege("Erro!", "Pedido com o " + id + " não foi encontrado!");
        }
    }
}





