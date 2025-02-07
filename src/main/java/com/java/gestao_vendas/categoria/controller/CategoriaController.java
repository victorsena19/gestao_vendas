package com.java.gestao_vendas.categoria.controller;

import com.java.gestao_vendas.categoria.dto.CategoriaDTO;
import com.java.gestao_vendas.categoria.entity.Categoria;
import com.java.gestao_vendas.categoria.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    public CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias(){
        List<Categoria> categorias = categoriaService.listarCategorias();
        return ResponseEntity.ok(categorias);
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> criarCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO){
        CategoriaDTO novaCategoria = categoriaService.criarCategoria(categoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria);
    }

    @PutMapping(value = {"/{id}"})
    public ResponseEntity<CategoriaDTO> atualizaCategoria(@Valid @PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO){
        CategoriaDTO categoriaAtualizada = categoriaService.atualizaCategoria(id, categoriaDTO);
        return ResponseEntity.ok().body(categoriaAtualizada);
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id){
         categoriaService.deletarCategoria(id);
       return ResponseEntity.noContent().build();
    }

}
