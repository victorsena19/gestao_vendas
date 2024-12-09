package com.java.gestao_vendas.empresa.mapper;

import com.java.gestao_vendas.empresa.dto.EmpresaDTO;
import com.java.gestao_vendas.empresa.entity.Empresa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmpresaMapper {
    EmpresaMapper INSTANCE = Mappers.getMapper(EmpresaMapper.class);

    EmpresaDTO toDTO(Empresa empresa);
    Empresa toEntity(EmpresaDTO empresaDTO);
}
