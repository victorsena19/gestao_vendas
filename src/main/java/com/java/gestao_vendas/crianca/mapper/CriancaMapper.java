package com.java.gestao_vendas.crianca.mapper;

import com.java.gestao_vendas.crianca.dto.CriancaDTO;
import com.java.gestao_vendas.crianca.entity.Crianca;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CriancaMapper {
    CriancaMapper INSTANCE = Mappers.getMapper(CriancaMapper.class);

    CriancaDTO toDTO(Crianca crianca);
    Crianca toEntity(CriancaDTO criancaDTO);
}
