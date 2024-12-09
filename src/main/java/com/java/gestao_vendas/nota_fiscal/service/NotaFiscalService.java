package com.java.gestao_vendas.nota_fiscal.service;

import com.java.gestao_vendas.nota_fiscal.dto.NotaFiscalDTO;
import com.java.gestao_vendas.nota_fiscal.entity.NotaFiscal;
import com.java.gestao_vendas.nota_fiscal.mapper.NotaFiscalMapper;
import com.java.gestao_vendas.nota_fiscal.repository.NotaFiscalRepository;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaFiscalService {
    private final NotaFiscalMapper notaFiscalMapper;
    private final NotaFiscalRepository notaFiscalRepository;

    @Autowired
    public NotaFiscalService(NotaFiscalMapper notaFiscalMapper, NotaFiscalRepository notaFiscalRepository) {
        this.notaFiscalMapper = notaFiscalMapper;
        this.notaFiscalRepository = notaFiscalRepository;
    }

    public List<NotaFiscal> listarNotasFiscais(){
        return notaFiscalRepository.findAll();
    }

    public NotaFiscalDTO salvarNotaFiscal(NotaFiscalDTO notaFiscalDTO){
        NotaFiscal novoNotaFiscal = notaFiscalMapper.toEntity(notaFiscalDTO);
        NotaFiscal notaFiscal = notaFiscalRepository.save(novoNotaFiscal);
        return notaFiscalMapper.toDTO(notaFiscal);
    }

    public Messege deletarNotaFiscal(Long id) {
        Optional<NotaFiscal> notaFiscal = notaFiscalRepository.findById(id);
        if (notaFiscal.isPresent()) {
            notaFiscalRepository.delete(notaFiscal.get());
            return new Messege("OK!", "NotaFiscal excluido com sucesso!");
        }else{
            return new Messege("Erro!", "NotaFiscal com o " + id + " não foi encontrado!");
        }
    }
}





