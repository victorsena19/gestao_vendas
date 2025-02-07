package com.java.gestao_vendas.vendedor.service;

import com.java.gestao_vendas.vendedor.dto.VendedorDTO;
import com.java.gestao_vendas.vendedor.entity.Vendedor;
import com.java.gestao_vendas.vendedor.mapper.VendedorMapper;
import com.java.gestao_vendas.vendedor.repository.VendedorRepository;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Vendedor> listarVendedores(){
        return vendedorRepository.findAll();
    }

    public VendedorDTO salvarVendedor(VendedorDTO vendedorDTO){
        Vendedor novoVendedor = vendedorMapper.toEntity(vendedorDTO);
        Vendedor vendedor = vendedorRepository.save(novoVendedor);
        return vendedorMapper.toDTO(vendedor);
    }

    public void deletarVendedor(Long id) {
        Vendedor vendedor = vendedorRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Não existe um vendedor com esse id: "));
            vendedorRepository.delete(vendedor);
    }

    public VendedorDTO criarVendedor(VendedorDTO vendedorDTO){
        return salvarVendedor(vendedorDTO);
    }

    public VendedorDTO atualizaVendedor(Long id, VendedorDTO vendedorDTO) {
        Vendedor vendedorId = vendedorRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Não existe vendedor com esse id : " + id));

        vendedorId.setDataContratacao(vendedorDTO.getDataContratacao());
        vendedorId.setComissao(vendedorDTO.getComissao());
        Vendedor vendedor = vendedorRepository.save(vendedorId);
        return vendedorMapper.toDTO(vendedor);
    }
}


