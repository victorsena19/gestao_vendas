package com.java.gestao_vendas.pedido.mapper;

import com.java.gestao_vendas.pedido.dto.PedidoDTO;
import com.java.gestao_vendas.pedido.entity.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PedidoMapper {
    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);

    PedidoDTO toDTO(Pedido pedido);
    Pedido toEntity(PedidoDTO pedidoDTO);
}
