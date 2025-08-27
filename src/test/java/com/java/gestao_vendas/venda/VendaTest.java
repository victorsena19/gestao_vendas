package com.java.gestao_vendas.venda;

import com.java.gestao_vendas.dto.ItemDTO;
import com.java.gestao_vendas.dto.ProdutoDTO;
import com.java.gestao_vendas.dto.VendaDTO;
import com.java.gestao_vendas.model.Venda;
import com.java.gestao_vendas.mapper.VendaMapper;
import com.java.gestao_vendas.repository.VendaRepository;
import com.java.gestao_vendas.service.VendaService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
/*
@SpringBootTest
public class VendaTest {

    @Mock
    private VendaRepository vendaRepository;

    @Mock
    private VendaMapper vendaMapper;

    @InjectMocks
    private VendaService vendaService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void criarVenda(){
        VendaDTO vendaDTO = new VendaDTO();

        ProdutoDTO p1 = new ProdutoDTO();
        p1.setNomeProduto("mustang");
        p1.setPreco(2590);

        ProdutoDTO p2 = new ProdutoDTO();
        p2.setNomeProduto("fusca");
        p2.setPreco(3290);

        ItemDTO vp1 = new ItemDTO();
        ItemDTO vp2 = new ItemDTO();

        vp1.setProduto(p1);
        vp1.setQuantidade(5);
        vp1.setVenda(vendaDTO);

        vp2.setProduto(p2);
        vp2.setQuantidade(3);
        vp2.setVenda(vendaDTO);

        List<ItemDTO> vp = new ArrayList<>();
        vp.add(vp1);
        vp.add(vp2);

        vendaDTO.setItem(vp);

        when(vendaMapper.toEntity(any())).thenReturn(new Venda());
        when(vendaMapper.toDTO(any())).thenReturn(vendaDTO);

        when(vendaRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        VendaDTO salvar = vendaService.criarVenda(vendaDTO);

        //assertEquals(22820, salvar.getTotalVenda(), 0.01);


    }
}
*/