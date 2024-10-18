package com.java.gestao_vendas.mapper;

import com.java.gestao_vendas.domain.DTO.CriancaDTO;
import com.java.gestao_vendas.domain.entity.Crianca;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CriancaMapper {
    CriancaMapper INSTANCE = Mappers.getMapper(CriancaMapper.class);

    CriancaDTO toDTO(Crianca crianca);
    Crianca toEntity(CriancaDTO criancaDTO);
}
