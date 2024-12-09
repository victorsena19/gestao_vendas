package com.java.gestao_vendas.service;

import com.java.gestao_vendas.domain.DTO.CupomFiscalDTO;
import com.java.gestao_vendas.domain.entity.CupomFiscal;
import com.java.gestao_vendas.mapper.CupomFiscalMapper;
import com.java.gestao_vendas.repository.CupomFiscalRepository;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CupomFiscalService {

    private final CupomFiscalMapper cupomFiscalMapper;
    private final CupomFiscalRepository cupomFiscalRepository;

    @Autowired
    public CupomFiscalService(CupomFiscalMapper cupomFiscalMapper, CupomFiscalRepository cupomFiscalRepository) {
        this.cupomFiscalMapper = cupomFiscalMapper;
        this.cupomFiscalRepository = cupomFiscalRepository;
    }

    public List<CupomFiscal> listarCuponsFiscais(){
        return cupomFiscalRepository.findAll();
    }

    public CupomFiscalDTO salvarCupomFiscal(CupomFiscalDTO cupomFiscalDTO){
        CupomFiscal novocupomFiscal = cupomFiscalMapper.toEntity(cupomFiscalDTO);
        CupomFiscal cupomFiscal = cupomFiscalRepository.save(novocupomFiscal);
        return cupomFiscalMapper.toDTO(cupomFiscal);
    }

    public Messege deletarcupomFiscal(Long id) {
        Optional<CupomFiscal> cupomFiscal = cupomFiscalRepository.findById(id);
        if (cupomFiscal.isPresent()) {
            cupomFiscalRepository.delete(cupomFiscal.get());
            return new Messege("OK!", "cupomFiscal excluido com sucesso!");
        }else{
            return new Messege("Erro!", "cupomFiscal com o " + id + " não foi encontrado!");
        }
    }
}


