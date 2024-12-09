package com.java.gestao_vendas.venda.service;

import com.java.gestao_vendas.venda.dto.VendaDTO;
import com.java.gestao_vendas.venda.entity.Venda;
import com.java.gestao_vendas.venda.mapper.VendaMapper;
import com.java.gestao_vendas.venda.repository.VendaRepository;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {
    private final VendaMapper vendaMapper;

    private final VendaRepository vendaRepository;
    public VendaService(VendaMapper vendaMapper, VendaRepository vendaRepository) {
        this.vendaMapper = vendaMapper;
        this.vendaRepository = vendaRepository;
    }

    public List<Venda> listarVendas(){
        return vendaRepository.findAll();
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

    public VendaDTO criarVenda(VendaDTO vendaDTO){
        return salvarVenda(vendaDTO);
    }

    public VendaDTO atualizaVenda(Long id, VendaDTO vendaDTO){
        Optional<Venda> vendaId = vendaRepository.findById(id);
            salvarVenda(vendaDTO);
        throw new IllegalArgumentException("Venda com o id" + vendaDTO.getId() + "não existe");

/*
    public void valorTotalVenda(VendaDTO venda) {
        double total = 0;
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


