package com.java.gestao_vendas.pagamento.service;

import com.java.gestao_vendas.pagamento.dto.PagamentoDTO;
import com.java.gestao_vendas.pagamento.entity.Pagamento;
import com.java.gestao_vendas.pagamento.mapper.PagamentoMapper;
import com.java.gestao_vendas.pagamento.repository.PagamentoRepository;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    private final PagamentoMapper pagamentoMapper;
    private final PagamentoRepository pagamentoRepository;

    @Autowired
    public PagamentoService(PagamentoRepository pagamentoRepository, PagamentoMapper pagamentoMapper) {
        this.pagamentoRepository = pagamentoRepository;
        this.pagamentoMapper = pagamentoMapper;
    }

    public List<Pagamento> listarPagamentos(){
        return pagamentoRepository.findAll();
    }

    public PagamentoDTO salvarPagamento(PagamentoDTO pagamentoDTO){
        Pagamento novoPagamento = pagamentoMapper.toEntity(pagamentoDTO);
        Pagamento pagamento = pagamentoRepository.save(novoPagamento);
        return pagamentoMapper.toDTO(pagamento);
    }

    public Messege deletarPagamento(Long id) {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
        if (pagamento.isPresent()) {
            pagamentoRepository.delete(pagamento.get());
            return new Messege("OK!", "Pagamento excluido com sucesso!");
        }else{
            return new Messege("Erro!", "Pagamento com o " + id + " não foi encontrado!");
        }
    }

    public PagamentoDTO criarPagamento(PagamentoDTO pagamentoDTO){
        return salvarPagamento(pagamentoDTO);
    }

    public PagamentoDTO atualizaPagamento(Long id, PagamentoDTO pagamentoDTO){
        pagamentoRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Não existe esse Tipo de Pagamento com o ID: " + id));
            return salvarPagamento(pagamentoDTO);
    }
}


