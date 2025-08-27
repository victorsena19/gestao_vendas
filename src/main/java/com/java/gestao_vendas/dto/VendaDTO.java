package com.java.gestao_vendas.dto;

import com.java.gestao_vendas.enums.StatusVenda;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaDTO{
    private Long id;
    private String tipoDocumento;
    private String numeroDocumento;
    private String chaveAcesso;
    @NotNull
    private List<ItemDTO> item;
    @Enumerated(EnumType.STRING)
    private StatusVenda statusVenda;
    private LocalDateTime dataVenda;
    @PositiveOrZero
    private BigDecimal desconto;
    @PositiveOrZero
    private BigDecimal totalVenda;
    @NotNull
    private List<PagamentoDTO> pagamento;
    @PositiveOrZero
    private BigDecimal restanteVenda;
    @NotNull
    private PessoaDTO pessoa;
    @NotNull
    private VendedorDTO vendedor;
}

