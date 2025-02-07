package com.java.gestao_vendas.pagamento.mapper;

import com.java.gestao_vendas.pagamento.dto.PagamentoDTO;
import com.java.gestao_vendas.pagamento.entity.Pagamento;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PagamentoMapper {
    PagamentoMapper INSTANCE = Mappers.getMapper(PagamentoMapper.class);

    PagamentoDTO toDTO(Pagamento pagamento);
    Pagamento toEntity(PagamentoDTO pagamentoDTO);
}
