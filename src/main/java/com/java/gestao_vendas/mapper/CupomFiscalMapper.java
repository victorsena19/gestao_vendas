package com.java.gestao_vendas.mapper;

import com.java.gestao_vendas.dto.CupomFiscalDTO;
import com.java.gestao_vendas.model.CupomFiscal;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CupomFiscalMapper {
    CupomFiscalMapper INSTANCE = Mappers.getMapper(CupomFiscalMapper.class);

    CupomFiscalDTO toDTO(CupomFiscal cupomFiscal);
    CupomFiscal toEntity(CupomFiscalDTO cupomFiscalDTO);
}
