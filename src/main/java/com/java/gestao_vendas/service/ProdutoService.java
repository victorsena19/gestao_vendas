package com.java.gestao_vendas.service;
import com.java.gestao_vendas.model.Categoria;
import com.java.gestao_vendas.repository.CategoriaRepository;
import com.java.gestao_vendas.dto.ProdutoDTO;
import com.java.gestao_vendas.model.Produto;
import com.java.gestao_vendas.mapper.ProdutoMapper;
import com.java.gestao_vendas.repository.ProdutoRepository;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService{

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;
    private final CategoriaRepository categoriaRepository;

    @Autowired
    public ProdutoService(ProdutoMapper produtoMapper, ProdutoRepository produtoRepository,
                          CategoriaRepository categoriaRepository){
        this.produtoMapper = produtoMapper;
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public ProdutoDTO listarProdutoId(Long id){
        Produto produto = produtoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Não existe um produto com o id: " + id));
        return produtoMapper.toDTO(produto);
    }

    public List<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public ProdutoDTO salvarProduto(ProdutoDTO produtoDTO){
        Produto novoProduto = produtoMapper.toEntity(produtoDTO);
        Produto produto = produtoRepository.save(novoProduto);
        return produtoMapper.toDTO(produto);
    }

    public Messege deletarProduto(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            produtoRepository.delete(produto.get());
            return new Messege("OK!", "Produto excluido com sucesso!");

            }else{
                return new Messege("Erro!", "Produto com o " + id + " não foi encontrado!");
            }
        }

    public ProdutoDTO criarProduto(ProdutoDTO produtoDTO){
        Produto produto = produtoMapper.toEntity(produtoDTO);
        boolean existsProduto = produtoRepository.existsByNomeProdutoIgnoreCase(produto.getNomeProduto());
        Categoria categoria = categoriaRepository.findById(produto.getCategoria().getId())
                .orElseThrow(()-> new IllegalArgumentException("Não existe uma categoria com o id: " + produto.getCategoria().getId()));
        if (existsProduto){
            throw new IllegalArgumentException("Já existe esse produto com o nome: " + produtoDTO.getNomeProduto());
        }
        produto.setCategoria(categoria);

        produtoRepository.save(produto);

        return produtoMapper.toDTO(produto);

    }

    public ProdutoDTO atualizaProduto(Long id, ProdutoDTO produtoDTO) {
        Produto produtoExistente = produtoRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Não existe o produto com o id: " + produtoDTO.getId()));
        boolean nomeProdutoExistente = produtoRepository.existsByNomeProdutoIgnoreCase(produtoDTO.getNomeProduto());
        if (nomeProdutoExistente && !produtoExistente.getNomeProduto().equalsIgnoreCase(produtoDTO.getNomeProduto())) {
                throw new IllegalArgumentException("Já existe um produto com o nome: " + produtoDTO.getNomeProduto());
        }
        /*
         Long categoriaId = produtoDTO.getCategoria().getId();
        if(categoriaId != null ){
            Categoria categoria = categoriaRepository.findById(categoriaId)
                    .orElseThrow(()-> new IllegalArgumentException("Não existe uma categoria com esse id: " + categoriaId));
            produtoExistente.setCategoria(categoria);
        }
        */

    /*
        Long pessoaId = produtoDTO.getPessoa().getIdPessoa();
        if(pessoaId != null ){
            Pessoa pessoa = pessoaRepository.findById(pessoaId)
                    .orElseThrow(()-> new IllegalArgumentException("Não existe uma pessoa com esse id: " + categoriaId));
            produtoExistente.setPessoa(pessoa);
*/

        produtoExistente.setNomeProduto(produtoDTO.getNomeProduto());
        produtoExistente.setDescricao(produtoDTO.getDescricao());
        produtoExistente.setPreco(produtoDTO.getPreco());
        produtoExistente.setQuantidadeEstoque(produtoDTO.getQuantidadeEstoque());
        produtoExistente.setAliquotaIpi(produtoDTO.getAliquotaIpi());
        produtoExistente.setAliquotaIcms(produtoDTO.getAliquotaIcms());
        produtoExistente.setNcmProduto(produtoDTO.getNcmProduto());
        produtoRepository.save(produtoExistente);

        return produtoMapper.toDTO(produtoExistente);

    }
}


