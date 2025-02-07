package com.java.gestao_vendas.item.controller;

import com.java.gestao_vendas.item.dto.ItemDTO;
import com.java.gestao_vendas.item.entity.Item;
import com.java.gestao_vendas.item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    public ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<List<Item>> listarItems(){
        List<Item> items = itemService.listarItems();
        return ResponseEntity.ok(items);
    }

    @PostMapping
    public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO itemDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.criarItem(itemDTO));
    }
}
