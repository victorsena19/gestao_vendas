package com.java.gestao_vendas.controller;

import com.java.gestao_vendas.dto.VendedorDTO;
import com.java.gestao_vendas.model.Vendedor;
import com.java.gestao_vendas.service.VendedorService;
import jakarta.validation.Valid;
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
    public ResponseEntity<VendedorDTO> criarVendedor(@Valid @RequestBody VendedorDTO vendedorDTO){
        VendedorDTO novaVendedor = vendedorService.criarVendedor(vendedorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaVendedor);
    }

    @PutMapping(value = {"/{id}"})
    public ResponseEntity<VendedorDTO> atualizaVendedor(@Valid @PathVariable Long id, @RequestParam VendedorDTO vendedorDTO){
        VendedorDTO vendedorAtualizada = vendedorService.atualizaVendedor(id, vendedorDTO);
        return ResponseEntity.ok().body(vendedorAtualizada);
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<Void> deleteVendedor(@PathVariable Long id){
          vendedorService.deletarVendedor(id);
        return ResponseEntity.noContent().build();
    }
}
