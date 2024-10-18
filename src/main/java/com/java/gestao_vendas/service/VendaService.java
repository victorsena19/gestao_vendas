package com.java.gestao_vendas.service;

import com.java.gestao_vendas.domain.DTO.VendaDTO;
import com.java.gestao_vendas.domain.entity.Venda;
import com.java.gestao_vendas.mapper.VendaMapper;
import com.java.gestao_vendas.repository.VendaRepository;
import com.java.gestao_vendas.utils.Messege;

import java.util.Optional;

public class VendaService {
    private final VendaMapper vendaMapper;

    private final VendaRepository vendaRepository;
    public VendaService(VendaMapper vendaMapper, VendaRepository vendaRepository) {
        this.vendaMapper = vendaMapper;
        this.vendaRepository = vendaRepository;
    }

    public VendaDTO salvarVenda(VendaDTO vendaDTO){
        Venda novaVenda = vendaMapper.toEntity(vendaDTO);
        Venda venda = vendaRepository.save(novaVenda);
        return vendaMapper.toDTO(venda);
    }

    public Messege deletarVenda(Long id) {
        Optional<Venda> venda = vendaRepository.findById(id);
        if (venda.isPresent()) {
            vendaRepository.delete(venda.get());
            return new Messege("OK!", "Venda excluido com sucesso!");
        }else{
            return new Messege("Erro!", "Venda com o " + id + " não foi encontrado!");
        }
    }

    public void valorTotalVenda(VendaDTO venda) {
        double total = 0;
/*
     for(VendaProduto vp : venda.getVendaProduto()){
         total += vp.getProduto().getPreco() * vp.getQuantidade();
     }
         if(venda.getDesconto() != 0){
            total = total - ((total * venda.getDesconto())/100);
         }
         venda.setValorTotal(total);
 */
    }
}


