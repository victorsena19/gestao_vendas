package com.java.gestao_vendas.pessoa.service;

import com.java.gestao_vendas.pessoa.dto.PessoaDTO;
import com.java.gestao_vendas.pessoa.entity.Pessoa;
import com.java.gestao_vendas.pessoa.mapper.PessoaMapper;
import com.java.gestao_vendas.pessoa.repository.PessoaRepository;
import com.java.gestao_vendas.utils.Messege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    private final PessoaMapper pessoaMapper;
    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaMapper pessoaMapper, PessoaRepository pessoaRepository){
        this.pessoaMapper = pessoaMapper;
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> listarPessoas(){
        return pessoaRepository.findAll();
    }
    
    public PessoaDTO salvarPessoa(PessoaDTO pessoaDTO){
        Pessoa novoPessoa = pessoaMapper.toEntity(pessoaDTO);
        Pessoa pessoa = pessoaRepository.save(novoPessoa);
        return pessoaMapper.toDTO(pessoa);
    }

    public Messege deletarPessoa(Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            pessoaRepository.delete(pessoa.get());
            return new Messege("OK!", "Pessoa excluido com sucesso!");
        }else{
            return new Messege("Erro!", "Pessoa com o " + id + " não foi encontrado!");
        }
    }

    public PessoaDTO criarPessoa(PessoaDTO pessoaDTO){
        Optional<Pessoa> emailExistente = pessoaRepository.findByEmailIgnoreCase(pessoaDTO.getEmail());
        Optional<Pessoa> cpfCnpjExistente = pessoaRepository.findByCnpjCpf(pessoaDTO.getCnpjCpf());
        if (emailExistente.isPresent()){
            throw new IllegalArgumentException("Pessoa com o email " + pessoaDTO.getEmail() + " já existe");
        }

        if (cpfCnpjExistente.isPresent()){
            throw new IllegalArgumentException("Pessoa com o cnpj ou cpf " + pessoaDTO.getCnpjCpf() + " já existe");
        }
        return salvarPessoa(pessoaDTO);
    }

    public PessoaDTO atualizaPessoa(Long id, PessoaDTO pessoaDTO) {
        Optional<Pessoa> pessoaId = pessoaRepository.findById(id);
        if (pessoaId.isPresent()) {
            Optional<Pessoa> emailPessoa = pessoaRepository.findByEmailIgnoreCase(pessoaDTO.getEmail());
            Optional<Pessoa> cpfCnpj = pessoaRepository.findByCnpjCpf(pessoaDTO.getCnpjCpf());
            if (emailPessoa.isPresent()){
                throw new IllegalArgumentException("Pessoa com o email" + pessoaDTO.getEmail() + "já existe existe");

            }
            if (cpfCnpj.isPresent()){
                throw new IllegalArgumentException("Pessoa com o cnpj ou cpf" + pessoaDTO.getCnpjCpf() + "já existe existe");
            }
            salvarPessoa(pessoaDTO);
        }
        throw new IllegalArgumentException("Pessoa com o id" + pessoaDTO.getId() + "não existe");
    }
}


