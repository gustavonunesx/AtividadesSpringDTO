package com.example.integracao.service;

import com.example.integracao.DTO.ProdutoDTO;
import com.example.integracao.entity.Produto;
import com.example.integracao.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto fromDTO(ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        produto.setId(produtoDTO.getId());
        produto.setNome(produtoDTO.getNome());
        produto.setPreco(Float.parseFloat(produtoDTO.getPreco()));
        produto.setQuantidade(produtoDTO.getQuantidade());

        return produto;
    }


    public ProdutoDTO toDTO(Produto produto){
        ProdutoDTO produtoDTO = new ProdutoDTO();
        produtoDTO.setId(produto.getId());
        produtoDTO.setNome(produto.getNome());
        produtoDTO.setPreco(String.valueOf(produto.getPreco()));
        produtoDTO.setQuantidade(produto.getQuantidade());

        return produtoDTO;
    }

    public List<Produto> getAll(){
        return produtoRepository.findAll();
    }


//        return alunoRepository.findById(id).map(this::toDTO);




    public ProdutoDTO saveDto(ProdutoDTO produtoDTO){
        Produto produto = this.fromDTO(produtoDTO);
        Produto produtoBd = produtoRepository.save(produto);
        return this.toDTO(produtoBd);
    }

}
