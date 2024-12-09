package com.java.gestao_vendas.produto.service;
import com.java.gestao_vendas.produto.dto.ProdutoDTO;
import com.java.gestao_vendas.produto.entity.Produto;
import com.java.gestao_vendas.produto.mapper.ProdutoMapper;
import com.java.gestao_vendas.produto.repository.ProdutoRepository;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
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

    public ProdutoDTO criarProduto(ProdutoDTO produtoDTO){
        List<Produto> nomeProduto = produtoRepository.findByNomeProdutoContainingIgnoreCase(produtoDTO.getNomeProduto());
        if (nomeProduto != null){
            throw new IllegalArgumentException("Produto com o nome" + produtoDTO.getNomeProduto() + "já existe");
        }
        return salvarProduto(produtoDTO);
    }

    public ProdutoDTO atualizaProduto(Long id, ProdutoDTO produtoDTO) {
        Optional<Produto> produtoId = produtoRepository.findById(id);
        if (produtoId.isPresent()) {
            List<Produto> nomeProduto = produtoRepository.findByNomeProdutoContainingIgnoreCase(produtoDTO.getNomeProduto());
            if (nomeProduto != null) {
                throw new IllegalArgumentException("Produto com o nome" + produtoDTO.getNomeProduto() + "já existe");
            }
            salvarProduto(produtoDTO);
        }
        throw new IllegalArgumentException("Produto com o id" + produtoDTO.getIdProduto() + "não existe");
    }
}


