package com.java.gestao_vendas.vendedor.mapper;

import com.java.gestao_vendas.vendedor.dto.VendedorDTO;
import com.java.gestao_vendas.vendedor.entity.Vendedor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VendedorMapper {
    VendedorMapper INSTANCE = Mappers.getMapper(VendedorMapper.class);

    VendedorDTO toDTO(Vendedor vendedor);
    Vendedor toEntity(VendedorDTO vendedorDTO);
}
