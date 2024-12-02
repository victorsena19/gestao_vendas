package com.java.gestao_vendas.mapper;

import com.java.gestao_vendas.domain.DTO.NotaFiscalDTO;
import com.java.gestao_vendas.domain.entity.NotaFiscal;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface NotaFiscalMapper {
    NotaFiscalMapper INSTANCE = Mappers.getMapper(NotaFiscalMapper.class);

    NotaFiscalDTO toDTO(NotaFiscal notaFiscal);
    NotaFiscal toEntity(NotaFiscalDTO notaFiscalDTO);
}
