package com.java.gestao_vendas.vendedor.controller;

import com.java.gestao_vendas.vendedor.dto.VendedorDTO;
import com.java.gestao_vendas.vendedor.entity.Vendedor;
import com.java.gestao_vendas.vendedor.service.VendedorService;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {
    public VendedorService vendedorService;

    @Autowired
    public VendedorController(VendedorService vendedorService){
        this.vendedorService = vendedorService;
    }

    @GetMapping
    public ResponseEntity<List<Vendedor>> listarVendedors(){
        List<Vendedor> vendedors = vendedorService.listarVendedores();
        return ResponseEntity.ok(vendedors);
    }

    @PostMapping
    public ResponseEntity<VendedorDTO> criarVendedor(VendedorDTO vendedorDTO){
        VendedorDTO novaVendedor = vendedorService.criarVendedor(vendedorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaVendedor);
    }

    @PutMapping(value = {"{/id}"})
    public ResponseEntity<VendedorDTO> atualizaVendedor(@PathVariable Long id, @RequestParam VendedorDTO vendedorDTO){
        VendedorDTO vendedorAtualizada = vendedorService.atualizaVendedor(id, vendedorDTO);
        return ResponseEntity.ok().body(vendedorAtualizada);
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<Messege> deleteVendedor(@PathVariable Long id){
        Messege vendedorExcluida = vendedorService.deletarVendedor(id);
        return ResponseEntity.ok().body(vendedorExcluida);
    }
}
