package com.java.gestao_vendas.service;

import com.java.gestao_vendas.domain.DTO.VendedorDTO;
import com.java.gestao_vendas.domain.entity.Vendedor;
import com.java.gestao_vendas.mapper.VendedorMapper;
import com.java.gestao_vendas.repository.VendedorRepository;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendedorService {
    private final VendedorMapper vendedorMapper;
    private final VendedorRepository vendedorRepository;

    @Autowired
    public VendedorService(VendedorMapper vendedorMapper, VendedorRepository vendedorRepository) {
        this.vendedorMapper = vendedorMapper;
        this.vendedorRepository = vendedorRepository;
    }

    public VendedorDTO salvarVendedor(VendedorDTO vendedorDTO){
        Vendedor novoVendedor = vendedorMapper.toEntity(vendedorDTO);
        Vendedor vendedor = vendedorRepository.save(novoVendedor);
        return vendedorMapper.toDTO(vendedor);
    }

    public Messege deletarVendedor(Long id) {
        Optional<Vendedor> vendedor = vendedorRepository.findById(id);
        if (vendedor.isPresent()) {
            vendedorRepository.delete(vendedor.get());
            return new Messege("OK!", "Vendedor excluido com sucesso!");
        }else{
            return new Messege("Erro!", "Vendedor com o " + id + " não foi encontrado!");
        }
    }
}


