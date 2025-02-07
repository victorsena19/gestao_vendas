package com.java.gestao_vendas.venda.service;

import com.java.gestao_vendas.item.repository.ItemRepository;
import com.java.gestao_vendas.pagamento.entity.Pagamento;
import com.java.gestao_vendas.pagamento.repository.PagamentoRepository;
import com.java.gestao_vendas.produto.entity.Produto;
import com.java.gestao_vendas.produto.repository.ProdutoRepository;
import com.java.gestao_vendas.tipo_pagamento.entity.TipoPagamento;
import com.java.gestao_vendas.tipo_pagamento.repository.TipoPagamentoRepository;
import com.java.gestao_vendas.venda.dto.VendaDTO;
import com.java.gestao_vendas.venda.entity.Venda;
import com.java.gestao_vendas.venda.enun.StatusVenda;
import com.java.gestao_vendas.venda.mapper.VendaMapper;
import com.java.gestao_vendas.venda.repository.VendaRepository;
import com.java.gestao_vendas.item.entity.Item;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Service
public class VendaService {

    private VendaMapper vendaMapper;
    private VendaRepository vendaRepository;
    private ProdutoRepository produtoRepository;
    private TipoPagamentoRepository tipoPagamentoRepository;

    @Autowired
    public VendaService(VendaMapper vendaMapper,
                        VendaRepository vendaRepository,
                        ProdutoRepository produtoRepository,
                        TipoPagamentoRepository tipoPagamentoRepository) {
        this.vendaMapper = vendaMapper;
        this.vendaRepository = vendaRepository;
        this.produtoRepository = produtoRepository;
        this.tipoPagamentoRepository = tipoPagamentoRepository;
    }

    public Venda listarVendaId(Long id){
        return vendaRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Essa existe uma venda com esse id: " + id));

    }

    public List<Venda> listarVendas(){
        return vendaRepository.findAll();
    }

    public void salvarVenda(VendaDTO vendaDTO){
        Venda novaVenda = vendaMapper.toEntity(vendaDTO);
        Venda venda = vendaRepository.save(novaVenda);
        vendaMapper.toDTO(venda);
    }

    public void deletarVenda(Long id) {
        Venda venda = vendaRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Nâo existe um uma venda com esse id: " + id));
        vendaRepository.delete(venda);
    }

    public VendaDTO atualizaVenda(Long id, VendaDTO vendaDTO) {
        // Verifica se a venda existe
        Venda vendaExistente = vendaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Não existe uma venda com esse id: " + id));

        // Atualiza os dados da venda
        Venda vendaAtualizada = vendaMapper.toEntity(vendaDTO);
        vendaAtualizada.setId(vendaExistente.getId());

        // Salva a venda atualizada
        Venda vendaSalva = vendaRepository.save(vendaAtualizada);

        return vendaMapper.toDTO(vendaSalva);
    }

    public VendaDTO criarVenda(VendaDTO vendaDTO) {
        Venda venda = vendaMapper.toEntity(vendaDTO);

        // Define a data da venda
        venda.setDataVenda(LocalDateTime.now());

        List<Item> itens = venda.getItem().stream().map((item)->{
        Produto produto = produtoRepository.findById(item.getProduto().getId()).orElseThrow(() ->
                new IllegalArgumentException("Não existe um produto com esse ID: " + item.getProduto().getId()));

        Item novoItem = new Item();
            novoItem.setProduto(produto);
            novoItem.setQuantidade(item.getQuantidade());
            novoItem.setDesconto(item.getDesconto());
            novoItem.setPrecoUnitario(produto.getPreco());
        BigDecimal valorSemDesconto = produto.getPreco().multiply(BigDecimal.valueOf(item.getQuantidade()));
        BigDecimal desconto = (item.getDesconto().divide(BigDecimal.valueOf(100)).multiply(valorSemDesconto));
        BigDecimal valorTotal = (valorSemDesconto.subtract(desconto));
            novoItem.setValorTotal(valorTotal);
            novoItem.setVenda(venda);

            //Atualiza saldo no estoque
            int tirarQuantidadeProdutoEstoque = produto.getQuantidadeEstoque()-item.getQuantidade();
            produto.setQuantidadeEstoque(tirarQuantidadeProdutoEstoque);
            return novoItem;
        }).collect(Collectors.toList());

        venda.setItem(itens);

        List<Pagamento> pagamentos = venda.getPagamento().stream().map((pagamento)->{
            TipoPagamento tipoPagamento = tipoPagamentoRepository.findById(pagamento.getTipoPagamento().getId()).orElseThrow(() ->
                    new IllegalArgumentException("Não existe um produto com esse ID: " + pagamento.getTipoPagamento().getId()));

            Pagamento novoPagamento = new Pagamento();
            novoPagamento.setTipoPagamento(tipoPagamento);
            novoPagamento.setVenda(venda);
            novoPagamento.setValorPago(pagamento.getValorPago());
            novoPagamento.setParcelamento(pagamento.getParcelamento());

            return novoPagamento;
        }).collect(Collectors.toList());

        venda.setPagamento(pagamentos);

        calcularVenda(venda);
        calcularPagamentoRestante(venda);

        // Salva a venda no banco
        Venda vendaSalva = vendaRepository.save(venda);

        // Retorna o DTO da venda salva
        return vendaMapper.toDTO(vendaSalva);
    }

    private BigDecimal calcularTotalSemDesconto(List<Item> itens) {
        return itens.stream()
                .map(item -> item.getPrecoUnitario().multiply(BigDecimal.valueOf(item.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private void aplicarDescontoGlobal(Venda venda, BigDecimal totalSemDesconto) {
        BigDecimal porcentagemDesconto = venda.getDesconto()
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);

        // Calcula o total com o desconto aplicado
        BigDecimal totalComDesconto = totalSemDesconto.multiply(BigDecimal.ONE.subtract(porcentagemDesconto));

        // Atualiza o valor total da venda
        venda.setTotalVenda(totalComDesconto);

        // Aplica o desconto proporcional em cada item
        venda.getItem().forEach(item -> {
            BigDecimal valorTotalItem = item.getPrecoUnitario().multiply(BigDecimal.valueOf(item.getQuantidade()));
            BigDecimal valorItemComDesconto = valorTotalItem.multiply(BigDecimal.ONE.subtract(porcentagemDesconto));
            item.setDesconto(venda.getDesconto());
            item.setValorTotal(valorItemComDesconto);
        });
    }

    private void calcularPorcentagemDescontoPorItem(Venda venda, BigDecimal totalSemDesconto) {
        BigDecimal totalComDesconto = venda.getItem().stream()
                .map(item -> {
                    BigDecimal porcentagemDesconto = item.getDesconto() != null
                            ? item.getDesconto().divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP)
                            : BigDecimal.ZERO;

                    BigDecimal totalItem = item.getPrecoUnitario().multiply(BigDecimal.valueOf(item.getQuantidade()));
                    return totalItem.multiply(BigDecimal.ONE.subtract(porcentagemDesconto));
                }).reduce(BigDecimal.ZERO, BigDecimal::add);

        // Calcula a porcentagem global de desconto
        BigDecimal descontoTotal = totalSemDesconto.subtract(totalComDesconto);
        BigDecimal porcentagemDescontoGlobal = descontoTotal.divide(totalSemDesconto, 4, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100));

        venda.setTotalVenda(totalComDesconto);
        venda.setDesconto(porcentagemDescontoGlobal); // Define a porcentagem global calculada
    }

    private void calcularVenda(Venda venda) {
        List<Item> itens = venda.getItem();
        BigDecimal totalSemDesconto = calcularTotalSemDesconto(itens);
        if (venda.getDesconto() != null) {
            aplicarDescontoGlobal(venda, totalSemDesconto);
        } else {
            calcularPorcentagemDescontoPorItem(venda, totalSemDesconto);
        }
    }

    private void calcularPagamentoRestante(Venda venda) {
        BigDecimal valorTotalVenda = venda.getTotalVenda();
        BigDecimal valorTotalPago = venda.getPagamento().stream()
                .map(Pagamento::getValorPago)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal valorRestante = valorTotalVenda.subtract(valorTotalPago);
        venda.setRestanteVenda(valorRestante);

        if (valorRestante.compareTo(BigDecimal.ZERO) > 0) {
            venda.setStatusVenda(StatusVenda.PENDENTE);
        } else {
            venda.setStatusVenda(StatusVenda.PAGO);
        }
    }

}




