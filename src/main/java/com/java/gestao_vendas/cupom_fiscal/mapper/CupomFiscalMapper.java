package com.java.gestao_vendas.cupom_fiscal.mapper;

import com.java.gestao_vendas.cupom_fiscal.dto.CupomFiscalDTO;
import com.java.gestao_vendas.cupom_fiscal.entity.CupomFiscal;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CupomFiscalMapper {
    CupomFiscalMapper INSTANCE = Mappers.getMapper(CupomFiscalMapper.class);

    CupomFiscalDTO toDTO(CupomFiscal cupomFiscal);
    CupomFiscal toEntity(CupomFiscalDTO cupomFiscalDTO);
}
