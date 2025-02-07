package com.java.gestao_vendas.endereco.controller;

import com.java.gestao_vendas.endereco.dto.EnderecoDTO;
import com.java.gestao_vendas.endereco.entity.Endereco;
import com.java.gestao_vendas.endereco.service.EnderecoService;
import com.java.gestao_vendas.utils.Messege;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    public EnderecoService enderecoService;

    @Autowired
    public EnderecoController(EnderecoService enderecoService){
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> listarEnderecos(){
        List<Endereco> enderecos = enderecoService.listarEnderecos();
        return ResponseEntity.ok(enderecos);
    }

    @PostMapping
    public ResponseEntity<EnderecoDTO> criarEndereco(@Valid @RequestBody EnderecoDTO enderecoDTO){
        EnderecoDTO novaEndereco = enderecoService.criarEndereco(enderecoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaEndereco);
    }

    @PutMapping(value = {"/{id}"})
    public ResponseEntity<EnderecoDTO> atualizaEndereco(@Valid @PathVariable Long id, @RequestParam EnderecoDTO enderecoDTO){
        EnderecoDTO enderecoAtualizada = enderecoService.atualizaEndereco(id, enderecoDTO);
        return ResponseEntity.ok().body(enderecoAtualizada);
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<Messege> deleteEndereco(@PathVariable Long id){
        Messege enderecoExcluida = enderecoService.deletarEndereco(id);
        return ResponseEntity.ok().body(enderecoExcluida);
    }
}
