package com.java.gestao_vendas.controller;

import com.java.gestao_vendas.domain.DTO.CategoriaDTO;
import com.java.gestao_vendas.domain.entity.Categoria;
import com.java.gestao_vendas.service.CategoriaService;
import com.java.gestao_vendas.utils.Messege;
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
    public ResponseEntity<CategoriaDTO> criarCategoria(CategoriaDTO categoriaDTO){
        CategoriaDTO novaCategoria = categoriaService.criarCategoria(categoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria);
    }

    @PutMapping(value = {"{/id}"})
    public ResponseEntity<CategoriaDTO> atualizaCategoria(@PathVariable Long id, @RequestParam CategoriaDTO categoriaDTO){
        CategoriaDTO categoriaAtualizada = categoriaService.atualizaCategoria(id, categoriaDTO);
        return ResponseEntity.ok().body(categoriaAtualizada);
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<Messege> deleteCategoria(@PathVariable Long id){
        Messege categoriaExcluida = categoriaService.deletarCategoria(id);
       return ResponseEntity.ok().body(categoriaExcluida);
    }

}
