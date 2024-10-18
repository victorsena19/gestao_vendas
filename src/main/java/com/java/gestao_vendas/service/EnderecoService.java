package com.java.gestao_vendas.service;

import com.java.gestao_vendas.domain.DTO.EnderecoDTO;
import com.java.gestao_vendas.domain.entity.Endereco;
import com.java.gestao_vendas.mapper.EnderecoMapper;
import com.java.gestao_vendas.repository.EnderecoRepository;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {

    private final EnderecoMapper enderecoMapper;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository, EnderecoMapper enderecoMapper) {
        this.enderecoRepository = enderecoRepository;
        this.enderecoMapper = enderecoMapper;
    }

    public EnderecoDTO salvarEndereco(EnderecoDTO enderecoDTO){
        Endereco novoEndereco = enderecoMapper.toEntity(enderecoDTO);
        Endereco endereco = enderecoRepository.save(novoEndereco);
        return enderecoMapper.toDTO(endereco);
    }

    public Messege deletarEndereco(Long id) {
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        if (endereco.isPresent()) {
            enderecoRepository.delete(endereco.get());
            return new Messege("OK!", "Endereco excluido com sucesso!");
        }else{
            return new Messege("Erro!", "Endereco com o " + id + " não foi encontrado!");
        }
    }
}


