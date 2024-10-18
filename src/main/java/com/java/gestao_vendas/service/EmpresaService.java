package com.java.gestao_vendas.service;

import com.java.gestao_vendas.domain.DTO.EmpresaDTO;
import com.java.gestao_vendas.domain.entity.Empresa;
import com.java.gestao_vendas.mapper.EmpresaMapper;
import com.java.gestao_vendas.repository.EmpresaRepository;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaService {
    private final EmpresaMapper empresaMapper;
    private final EmpresaRepository empresaRepository;

    @Autowired
    public EmpresaService(EmpresaMapper empresaMapper, EmpresaRepository empresaRepository){
        this.empresaMapper = empresaMapper;
        this.empresaRepository = empresaRepository;
    }
    
    public EmpresaDTO salvarEmpresa(EmpresaDTO empresaDTO){
        Empresa novoEmpresa = empresaMapper.toEntity(empresaDTO);
        Empresa empresa = empresaRepository.save(novoEmpresa);
        return empresaMapper.toDTO(empresa);
    }

    public Messege deletarEmpresa(Long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        if (empresa.isPresent()) {
            empresaRepository.delete(empresa.get());
            return new Messege("OK!", "Empresa excluido com sucesso!");
        }else{
            return new Messege("Erro!", "Empresa com o " + id + " não foi encontrado!");
        }
    }
}


