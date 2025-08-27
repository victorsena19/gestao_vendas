package com.java.gestao_vendas.service;

import com.java.gestao_vendas.dto.ItemDTO;
import com.java.gestao_vendas.model.Item;
import com.java.gestao_vendas.mapper.ItemMapper;
import com.java.gestao_vendas.repository.ItemRepository;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemMapper itemMapper;
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemMapper itemMapper, ItemRepository itemRepository){
        this.itemMapper = itemMapper;
        this.itemRepository = itemRepository;
    }

    public List<Item> listarItems(){
        return itemRepository.findAll();
    }

    public ItemDTO salvarItem(ItemDTO itemDTO){
        Item novoItem = itemMapper.toEntity(itemDTO);
        Item item = itemRepository.save(novoItem);
        return itemMapper.toDTO(item);
    }

    public Messege deletarItem(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            itemRepository.delete(item.get());
            return new Messege("OK!", "Item excluido com sucesso!");
        }else{
            return new Messege("Erro!", "Item com o " + id + " não foi encontrado!");
        }
    }

    public ItemDTO criarItem(ItemDTO itemDTO){
        Item item = itemMapper.toEntity(itemDTO);
        itemRepository.save(item);
        return  itemMapper.toDTO(item);
    }


}


