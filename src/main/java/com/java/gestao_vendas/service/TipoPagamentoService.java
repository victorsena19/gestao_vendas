package com.java.gestao_vendas.service;

import com.java.gestao_vendas.dto.TipoPagamentoDTO;
import com.java.gestao_vendas.model.TipoPagamento;
import com.java.gestao_vendas.mapper.TipoPagamentoMapper;
import com.java.gestao_vendas.repository.TipoPagamentoRepository;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoPagamentoService {

    private final TipoPagamentoMapper tipoPagamentoMapper;
    private final TipoPagamentoRepository tipoPagamentoRepository;

    @Autowired
    public TipoPagamentoService(TipoPagamentoRepository tipoPagamentoRepository, TipoPagamentoMapper tipoPagamentoMapper) {
        this.tipoPagamentoRepository = tipoPagamentoRepository;
        this.tipoPagamentoMapper = tipoPagamentoMapper;
    }

    public List<TipoPagamento> listarTipoPagamentos(){
        return tipoPagamentoRepository.findAll();
    }

    public TipoPagamentoDTO salvarTipoPagamento(TipoPagamentoDTO tipoPagamentoDTO){
        TipoPagamento novoTipoPagamento = tipoPagamentoMapper.toEntity(tipoPagamentoDTO);
        TipoPagamento tipoPagamento = tipoPagamentoRepository.save(novoTipoPagamento);
        return tipoPagamentoMapper.toDTO(tipoPagamento);
    }

    public Messege deletarTipoPagamento(Long id) {
        Optional<TipoPagamento> tipoPagamento = tipoPagamentoRepository.findById(id);
        if (tipoPagamento.isPresent()) {
            tipoPagamentoRepository.delete(tipoPagamento.get());
            return new Messege("OK!", "TipoPagamento excluido com sucesso!");
        }else{
            return new Messege("Erro!", "TipoPagamento com o " + id + " não foi encontrado!");
        }
    }

    public TipoPagamentoDTO criarTipoPagamento(TipoPagamentoDTO tipoPagamentoDTO){
        boolean nomeTipoPagamento = tipoPagamentoRepository.existsByNomePagamentoIgnoreCase(tipoPagamentoDTO.getNomePagamento());
        if (nomeTipoPagamento){
            throw new IllegalArgumentException("Tipo de Pagamento " + tipoPagamentoDTO.getNomePagamento() + " já existe");
        }
        return salvarTipoPagamento(tipoPagamentoDTO);
    }

    public TipoPagamentoDTO atualizaTipoPagamento(Long id, TipoPagamentoDTO tipoPagamentoDTO){
        tipoPagamentoRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Não existe esse Tipo de Pagamento com o ID: " + id));
        boolean nomeTipoPagamento = tipoPagamentoRepository.existsByNomePagamentoIgnoreCase(tipoPagamentoDTO.getNomePagamento());
        if (nomeTipoPagamento){
            throw new IllegalArgumentException("Tipo de Pagamento " + tipoPagamentoDTO.getNomePagamento() + " já existe");
        }
            return salvarTipoPagamento(tipoPagamentoDTO);
    }
}


