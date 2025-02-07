package com.java.gestao_vendas.crianca.service;

import com.java.gestao_vendas.crianca.dto.CriancaDTO;
import com.java.gestao_vendas.crianca.entity.Crianca;
import com.java.gestao_vendas.crianca.mapper.CriancaMapper;
import com.java.gestao_vendas.crianca.repository.CriancaRepository;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CriancaService {

    private final CriancaMapper criancaMapper;
    private final CriancaRepository criancaRepository;

    @Autowired
    public CriancaService(CriancaMapper criancaMapper, CriancaRepository criancaRepository){
        this.criancaMapper = criancaMapper;
        this.criancaRepository = criancaRepository;
    }

    public CriancaDTO salvarCrianca(CriancaDTO criancaDTO){
        Crianca novoCrianca = criancaMapper.toEntity(criancaDTO);
        Crianca crianca = criancaRepository.save(novoCrianca);
        return criancaMapper.toDTO(crianca);
    }

    public List<Crianca> listarCriancas(){
        return criancaRepository.findAll();
    }

    public Messege deletarCrianca(Long id) {
        Optional<Crianca> crianca = criancaRepository.findById(id);
        if (crianca.isPresent()) {
            criancaRepository.delete(crianca.get());
            return new Messege("OK!", "Crianca excluido com sucesso!");
        }else{
            return new Messege("Erro!", "Crianca com o " + id + " não foi encontrado!");
        }
    }

    public CriancaDTO criarCrianca(CriancaDTO criancaDTO){
        System.out.println(criancaDTO);
        return salvarCrianca(criancaDTO);
    }

    public CriancaDTO atualizaCrianca(Long id, CriancaDTO criancaDTO){
        Optional<Crianca> criancaId = criancaRepository.findById(id);
        if(criancaId.isPresent()){
            salvarCrianca(criancaDTO);
        }
        throw new IllegalArgumentException("Crianca com o id" + criancaDTO.getId() + "não existe");
    }
}


