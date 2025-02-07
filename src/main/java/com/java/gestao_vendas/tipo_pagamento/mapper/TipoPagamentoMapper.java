package com.java.gestao_vendas.status_pagamento.mapper;

import com.java.gestao_vendas.status_pagamento.dto.StatusPagamentoDTO;
import com.java.gestao_vendas.status_pagamento.entity.StatusPagamento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StatusPagamentoMapper {
    StatusPagamentoMapper INSTANCE = Mappers.getMapper(StatusPagamentoMapper.class);

    StatusPagamentoDTO toDTO(StatusPagamento statusPagamento);
    StatusPagamento toEntity(StatusPagamentoDTO statusPagamentoDTO);
}
