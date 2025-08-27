package com.java.gestao_vendas.service;

import com.java.gestao_vendas.model.Pagamento;
import com.java.gestao_vendas.dto.PedidoDTO;
import com.java.gestao_vendas.model.Pedido;
import com.java.gestao_vendas.mapper.PedidoMapper;
import com.java.gestao_vendas.repository.PedidoRepository;
import com.java.gestao_vendas.model.TipoPagamento;
import com.java.gestao_vendas.repository.TipoPagamentoRepository;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    private final PedidoMapper pedidoMapper;
    private final PedidoRepository pedidoRepository;
    private TipoPagamentoRepository tipoPagamentoRepository;

    @Autowired
    public PedidoService(PedidoMapper pedidoMapper, PedidoRepository pedidoRepository, TipoPagamentoRepository tipoPagamentoRepository){
        this.pedidoMapper = pedidoMapper;
        this.pedidoRepository = pedidoRepository;
        this.tipoPagamentoRepository = tipoPagamentoRepository;
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
        Pedido pedido = pedidoMapper.toEntity(pedidoDTO);
        pedido.setDataPedido(LocalDateTime.now());
        TipoPagamento tipoPagamento = tipoPagamentoRepository.findById(pedido.getPagamento().getTipoPagamento().getId())
                .orElseThrow(()-> new IllegalArgumentException("não existe esse tipo pagamento com esse ID: " + pedido.getPagamento().getTipoPagamento().getId()));
        Pagamento pagamento = new Pagamento();
        pagamento.setTipoPagamento(tipoPagamento);
        pagamento.setParcelamento(pedido.getPagamento().getParcelamento());
        pagamento.setValorPago(pedido.getPagamento().getValorPago());

        PedidoDTO novoPedidoDTO = pedidoMapper.toDTO(pedido);
        return salvarPedido(novoPedidoDTO);
    }

    public PedidoDTO atualizaPedido(Long id, PedidoDTO pedidoDTO) {
        Optional<Pedido> pedidoId = pedidoRepository.findById(id);
        if (pedidoId.isPresent()) {
            salvarPedido(pedidoDTO);
        }
        throw new IllegalArgumentException("Pedido com o id" + pedidoDTO.getId() + "não existe");
    }
}





