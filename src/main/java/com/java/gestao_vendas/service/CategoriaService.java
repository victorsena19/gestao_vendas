package com.java.gestao_vendas.service;

import com.java.gestao_vendas.dto.CategoriaDTO;
import com.java.gestao_vendas.model.Categoria;
import com.java.gestao_vendas.mapper.CategoriaMapper;
import com.java.gestao_vendas.model.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaMapper categoriaMapper;
    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaMapper categoriaMapper, CategoriaRepository categoriaRepository){
        this.categoriaMapper = categoriaMapper;
        this.categoriaRepository = categoriaRepository;
    }


    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }

    public void deletarCategoria(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Não existe uma categoria com esse id: " + id));
        categoriaRepository.delete(categoria);
    }

    public CategoriaDTO salvarCategoria(CategoriaDTO categoriaDTO){
        Categoria novoCategoria = categoriaMapper.toEntity(categoriaDTO);
        Categoria categoria = categoriaRepository.save(novoCategoria);
        return categoriaMapper.toDTO(categoria);
    }

    public CategoriaDTO criarCategoria(CategoriaDTO categoriaDTO){
        boolean existsCategoria = categoriaRepository.existsByNomeIgnoreCase(categoriaDTO.getNome());
        if (existsCategoria){
            throw new IllegalArgumentException("Já existe uma categoria com o nome: " + categoriaDTO.getNome());
        }
        return salvarCategoria(categoriaDTO);
    }

    public CategoriaDTO atualizaCategoria(Long id, CategoriaDTO categoriaDTO) {
        Categoria categoriaExistente = categoriaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Não existe uma categoria com o id:" + id));
        boolean existsCategoria = categoriaRepository.existsByNomeIgnoreCase(categoriaDTO.getNome());
        if (existsCategoria && !categoriaExistente.getNome().equalsIgnoreCase(categoriaDTO.getNome())) {
            throw new IllegalArgumentException("Já existe uma categoria com o nome: " + categoriaDTO.getNome());
        }

        categoriaExistente.setNome(categoriaDTO.getNome());
        categoriaExistente.setDescricao(categoriaDTO.getDescricao());

        Categoria categoriaAtualizada = categoriaRepository.save(categoriaExistente);

        return categoriaMapper.toDTO(categoriaAtualizada);
    }
}


