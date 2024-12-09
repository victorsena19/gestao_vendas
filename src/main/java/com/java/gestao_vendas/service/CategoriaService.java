package com.java.gestao_vendas.service;

import com.java.gestao_vendas.domain.DTO.CategoriaDTO;
import com.java.gestao_vendas.domain.entity.Categoria;
import com.java.gestao_vendas.mapper.CategoriaMapper;
import com.java.gestao_vendas.repository.CategoriaRepository;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaMapper categoriaMapper;
    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaMapper categoriaMapper, CategoriaRepository categoriaRepository){
        this.categoriaMapper = categoriaMapper;
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaDTO salvarCategoria(CategoriaDTO categoriaDTO){
        Categoria novoCategoria = categoriaMapper.toEntity(categoriaDTO);
        Categoria categoria = categoriaRepository.save(novoCategoria);
        return categoriaMapper.toDTO(categoria);
    }

    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }

    public Messege deletarCategoria(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()) {
            categoriaRepository.delete(categoria.get());
            return new Messege("OK!", "Categoria excluido com sucesso!");
        }else{
            return new Messege("Erro!", "Categoria com o " + id + " não foi encontrado!");
        }
    }

    public CategoriaDTO criarCategoria(CategoriaDTO categoriaDTO){
        List<Categoria> nomeCategoria = categoriaRepository.findByNomeContainsIgnoreCase(categoriaDTO.getNome());
        if (nomeCategoria != null){
            throw new IllegalArgumentException("Categoria com o nome" + categoriaDTO.getNome() + "já existe");
        }
        return salvarCategoria(categoriaDTO);
    }

    public CategoriaDTO atualizaCategoria(Long id, CategoriaDTO categoriaDTO){
        Optional<Categoria> categoriaId = categoriaRepository.findById(id);
        if(categoriaId.isPresent()){
            List<Categoria> nomeCategoria = categoriaRepository.findByNomeContainsIgnoreCase(categoriaDTO.getNome());
            if (nomeCategoria != null){
                throw new IllegalArgumentException("Categoria com o nome" + categoriaDTO.getNome() + "já existe");
            }
            salvarCategoria(categoriaDTO);
        }
        throw new IllegalArgumentException("Categoria com o id" + categoriaDTO.getId() + "não existe");
    }
}


