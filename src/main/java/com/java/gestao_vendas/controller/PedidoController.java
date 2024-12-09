package com.java.gestao_vendas.controller;

import com.java.gestao_vendas.domain.DTO.PedidoDTO;
import com.java.gestao_vendas.domain.entity.Pedido;
import com.java.gestao_vendas.service.PedidoService;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    
    public PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos(){
        List<Pedido> pedidos = pedidoService.listarPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> criarPedido(PedidoDTO pedidoDTO){
        PedidoDTO novaPedido = pedidoService.criarPedido(pedidoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaPedido);
    }

    @PutMapping(value = {"{/id}"})
    public ResponseEntity<PedidoDTO> atualizaPedido(@PathVariable Long id, @RequestParam PedidoDTO pedidoDTO){
        PedidoDTO pedidoAtualizada = pedidoService.atualizaPedido(id, pedidoDTO);
        return ResponseEntity.ok().body(pedidoAtualizada);
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<Messege> deletePedido(@PathVariable Long id){
        Messege pedidoExcluida = pedidoService.deletarPedido(id);
        return ResponseEntity.ok().body(pedidoExcluida);
    }
}
