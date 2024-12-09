package com.java.gestao_vendas.endereco.service;

import com.java.gestao_vendas.endereco.dto.EnderecoDTO;
import com.java.gestao_vendas.endereco.entity.Endereco;
import com.java.gestao_vendas.endereco.mapper.EnderecoMapper;
import com.java.gestao_vendas.endereco.repository.EnderecoRepository;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Endereco> listarEnderecos(){
        return enderecoRepository.findAll();
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

    public EnderecoDTO criarEndereco(EnderecoDTO enderecoDTO){
        List<Endereco> nomeEndereco = enderecoRepository.findByLogradouroContainingIgnoreCase(enderecoDTO.getLogradouro());
        List<Endereco> numero = enderecoRepository.findByNumero(enderecoDTO.getNumero());
        if (nomeEndereco != null && numero != null ){
            throw new IllegalArgumentException("Endereco " + enderecoDTO.getLogradouro() + " com o numero " + numero + " já existe");
        }
        return salvarEndereco(enderecoDTO);
    }

    public EnderecoDTO atualizaEndereco(Long id, EnderecoDTO enderecoDTO){
        Optional<Endereco> enderecoId = enderecoRepository.findById(id);
        if(enderecoId.isPresent()){
            List<Endereco> nomeEndereco = enderecoRepository.findByLogradouroContainingIgnoreCase(enderecoDTO.getLogradouro());
            List<Endereco> numero = enderecoRepository.findByNumero(enderecoDTO.getNumero());
            if (nomeEndereco != null && numero != null){
                throw new IllegalArgumentException("Endereco " + enderecoDTO.getLogradouro() + " com o numero " + numero + " já existe");
            }
            salvarEndereco(enderecoDTO);
        }
        throw new IllegalArgumentException("Endereco com o id " + enderecoDTO.getId() + " não existe");
    }
}


