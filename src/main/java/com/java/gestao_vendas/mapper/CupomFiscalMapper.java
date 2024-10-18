package com.java.gestao_vendas.mapper;

import com.java.gestao_vendas.domain.DTO.CupomFiscalDTO;
import com.java.gestao_vendas.domain.entity.CupomFiscal;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CupomFiscalMapper {
    CupomFiscalMapper INSTANCE = Mappers.getMapper(CupomFiscalMapper.class);

    CupomFiscalDTO toDTO(CupomFiscal cupomFiscal);
    CupomFiscal toEntity(CupomFiscalDTO cupomFiscalDTO);
}
