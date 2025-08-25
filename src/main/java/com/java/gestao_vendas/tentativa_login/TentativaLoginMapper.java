package com.java.gestao_vendas.tentativa_login;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TentativaLoginMapper {
    TentativaLoginDTO toDTO(TentativaLogin tentativaLogin);
    List<TentativaLoginDTO> toDTO(List<TentativaLogin> tentativaLogin);
    TentativaLogin toEntity(TentativaLoginDTO tentativaLoginDTO);
}
