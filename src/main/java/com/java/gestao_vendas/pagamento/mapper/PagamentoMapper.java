package com.java.gestao_vendas.tipo_pagamento.mapper;

import com.java.gestao_vendas.tipo_pagamento.dto.TipoPagamentoDTO;
import com.java.gestao_vendas.tipo_pagamento.entity.TipoPagamento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TipoPagamentoMapper {
    TipoPagamentoMapper INSTANCE = Mappers.getMapper(TipoPagamentoMapper.class);

    TipoPagamentoDTO toDTO(TipoPagamento tipoPagamento);
    TipoPagamento toEntity(TipoPagamentoDTO tipoPagamentoDTO);
}
