package com.java.gestao_vendas.mapper;

import com.java.gestao_vendas.domain.DTO.PedidoDTO;
import com.java.gestao_vendas.domain.entity.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PedidoMapper {
    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);

    PedidoDTO toDTO(Pedido pedido);
    Pedido toEntity(PedidoDTO pedidoDTO);
}
