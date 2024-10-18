package com.java.gestao_vendas.service;

import com.java.gestao_vendas.domain.DTO.PessoaDTO;
import com.java.gestao_vendas.domain.entity.Pessoa;
import com.java.gestao_vendas.mapper.PessoaMapper;
import com.java.gestao_vendas.mapper.PessoaMapper;
import com.java.gestao_vendas.repository.PessoaRepository;
import com.java.gestao_vendas.repository.PessoaRepository;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {
    private final PessoaMapper pessoaMapper;
    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaMapper pessoaMapper, PessoaRepository pessoaRepository){
        this.pessoaMapper = pessoaMapper;
        this.pessoaRepository = pessoaRepository;
    }
    
    public PessoaDTO salvarPessoa(PessoaDTO pessoaDTO){
        Pessoa novoPessoa = pessoaMapper.toEntity(pessoaDTO);
        Pessoa pessoa = pessoaRepository.save(novoPessoa);
        return pessoaMapper.toDTO(pessoa);
    }

    public Messege deletarPessoa(Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            pessoaRepository.delete(pessoa.get());
            return new Messege("OK!", "Pessoa excluido com sucesso!");
        }else{
            return new Messege("Erro!", "Pessoa com o " + id + " não foi encontrado!");
        }
    }
}


