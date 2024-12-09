package com.java.gestao_vendas.service;

import com.java.gestao_vendas.domain.DTO.VendaProdutoDTO;
import com.java.gestao_vendas.domain.entity.VendaProduto;
import com.java.gestao_vendas.mapper.VendaProdutoMapper;
import com.java.gestao_vendas.mapper.VendaProdutoMapper;
import com.java.gestao_vendas.repository.VendaProdutoRepository;
import com.java.gestao_vendas.repository.VendaProdutoRepository;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaProdutoService {

    private final VendaProdutoMapper vendaProdutoMapper;
    private final VendaProdutoRepository vendaProdutoRepository;

    @Autowired
    public VendaProdutoService(VendaProdutoMapper vendaProdutoMapper, VendaProdutoRepository vendaProdutoRepository){
        this.vendaProdutoMapper = vendaProdutoMapper;
        this.vendaProdutoRepository = vendaProdutoRepository;
    }

    public List<VendaProduto> listarVendaProdutos(){
        return vendaProdutoRepository.findAll();
    }

    public VendaProdutoDTO salvarVendaProduto(VendaProdutoDTO vendaProdutoDTO){
        VendaProduto novoVendaProduto = vendaProdutoMapper.toEntity(vendaProdutoDTO);
        VendaProduto vendaProduto = vendaProdutoRepository.save(novoVendaProduto);
        return vendaProdutoMapper.toDTO(vendaProduto);
    }

    public Messege deletarVendaProduto(Long id) {
        Optional<VendaProduto> vendaProduto = vendaProdutoRepository.findById(id);
        if (vendaProduto.isPresent()) {
            vendaProdutoRepository.delete(vendaProduto.get());
            return new Messege("OK!", "VendaProduto excluido com sucesso!");
        }else{
            return new Messege("Erro!", "VendaProduto com o " + id + " não foi encontrado!");
        }
    }
}


