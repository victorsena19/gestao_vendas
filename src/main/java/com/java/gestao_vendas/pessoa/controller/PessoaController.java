package com.java.gestao_vendas.pessoa.controller;

import com.java.gestao_vendas.pessoa.dto.PessoaDTO;
import com.java.gestao_vendas.pessoa.entity.Pessoa;
import com.java.gestao_vendas.pessoa.service.PessoaService;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    public PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas(){
        List<Pessoa> pessoas = pessoaService.listarPessoas();
        return ResponseEntity.ok(pessoas);
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> criarPessoa(PessoaDTO pessoaDTO){
        PessoaDTO novaPessoa = pessoaService.criarPessoa(pessoaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaPessoa);
    }

    @PutMapping(value = {"{/id}"})
    public ResponseEntity<PessoaDTO> atualizaPessoa(@PathVariable Long id, @RequestParam PessoaDTO pessoaDTO){
        PessoaDTO pessoaAtualizada = pessoaService.atualizaPessoa(id, pessoaDTO);
        return ResponseEntity.ok().body(pessoaAtualizada);
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<Messege> deletePessoa(@PathVariable Long id){
        Messege pessoaExcluida = pessoaService.deletarPessoa(id);
        return ResponseEntity.ok().body(pessoaExcluida);
    }
}
