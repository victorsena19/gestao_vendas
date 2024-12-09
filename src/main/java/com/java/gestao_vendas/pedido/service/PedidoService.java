package com.java.gestao_vendas.pedido.service;

import com.java.gestao_vendas.pedido.dto.PedidoDTO;
import com.java.gestao_vendas.pedido.entity.Pedido;
import com.java.gestao_vendas.pedido.mapper.PedidoMapper;
import com.java.gestao_vendas.pedido.repository.PedidoRepository;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Pedido> listarPedidos(){
        return pedidoRepository.findAll();
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

    public PedidoDTO criarPedido(PedidoDTO pedidoDTO){
        return salvarPedido(pedidoDTO);
    }

    public PedidoDTO atualizaPedido(Long id, PedidoDTO pedidoDTO) {
        Optional<Pedido> pedidoId = pedidoRepository.findById(id);
        if (pedidoId.isPresent()) {
            salvarPedido(pedidoDTO);
        }
        throw new IllegalArgumentException("Pedido com o id" + pedidoDTO.getIdPedido() + "não existe");
    }
}





