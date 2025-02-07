package com.java.gestao_vendas.venda_produto.service;

import com.java.gestao_vendas.venda_produto.dto.VendaProdutoDTO;
import com.java.gestao_vendas.venda_produto.entity.VendaProduto;
import com.java.gestao_vendas.venda_produto.mapper.ItemMapper;
import com.java.gestao_vendas.venda_produto.mapper.VendaProdutoMapper;
import com.java.gestao_vendas.venda_produto.repository.ItemRepository;
import com.java.gestao_vendas.venda_produto.repository.VendaProdutoRepository;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ItemService {

    private final ItemMapper itemMapper;
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemMapper itemMapper, ItemRepository itemRepository){
        this.itemMapper = itemMapper;
        this.itemRepository = itemRepository;
    }

    public List<VendaProduto> listarVendaProdutos(){
        return vendaProdutoRepository.findAll();
    }

    public VendaProdutoDTO salvarVendaProduto(VendaProdutoDTO vendaProdutoDTO){
        VendaProduto novoVendaProduto = vendaProdutoMapper.toEntity(vendaProdutoDTO);
        VendaProduto vendaProduto = vendaProdutoRepository.save(novoVendaProduto);
        return vendaProdutoMapper.toDTO(vendaProduto);
    }

    public Messege deletarVendaProduto(UUID id) {
        Optional<VendaProduto> vendaProduto = vendaProdutoRepository.findById(id);
        if (vendaProduto.isPresent()) {
            vendaProdutoRepository.delete(vendaProduto.get());
            return new Messege("OK!", "VendaProduto excluido com sucesso!");
        }else{
            return new Messege("Erro!", "VendaProduto com o " + id + " não foi encontrado!");
        }
    }

    public VendaProdutoDTO criarVendaProduto(VendaProdutoDTO vendaProdutoDTO){
        VendaProduto vendaProduto = vendaProdutoMapper.toEntity(vendaProdutoDTO);
        vendaProdutoRepository.save(vendaProduto);
        return  vendaProdutoMapper.toDTO(vendaProduto);
    }


}


