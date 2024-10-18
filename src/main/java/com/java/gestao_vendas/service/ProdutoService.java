package com.java.gestao_vendas.service;
import com.java.gestao_vendas.domain.DTO.ProdutoDTO;
import com.java.gestao_vendas.domain.entity.Produto;
import com.java.gestao_vendas.mapper.ProdutoMapper;
import com.java.gestao_vendas.repository.ProdutoRepository;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService{

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    @Autowired
    public ProdutoService(ProdutoMapper produtoMapper, ProdutoRepository produtoRepository){
        this.produtoMapper = produtoMapper;
        this.produtoRepository = produtoRepository;
    }
    
    public ProdutoDTO salvarProduto(ProdutoDTO produtoDTO){
        Produto novoProduto = produtoMapper.toEntity(produtoDTO);
        Produto produto = produtoRepository.save(novoProduto);
        return produtoMapper.toDTO(produto);
    }

    public Messege deletarProduto(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            produtoRepository.delete(produto.get());
            return new Messege("OK!", "Produto excluido com sucesso!");

            }else{
                return new Messege("Erro!", "Produto com o " + id + " não foi encontrado!");
            }
        }
    }


