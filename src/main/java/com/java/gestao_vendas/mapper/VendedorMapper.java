package com.java.gestao_vendas.mapper;

import com.java.gestao_vendas.domain.DTO.VendedorDTO;
import com.java.gestao_vendas.domain.entity.Vendedor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VendedorMapper {
    VendedorMapper INSTANCE = Mappers.getMapper(VendedorMapper.class);

    VendedorDTO toDTO(Vendedor vendedor);
    Vendedor toEntity(VendedorDTO vendedorDTO);
}
