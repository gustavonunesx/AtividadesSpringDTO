package com.example.integracao.service;

import com.example.integracao.DTO.ProdutoDTO;
import com.example.integracao.entity.Produto;
import com.example.integracao.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto fromDTO(ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        produto.setId(produtoDTO.getId());
        produto.setNome(produtoDTO.getNome());

        try {
            produto.setPreco(Float.parseFloat(produtoDTO.getPreco()));
        } catch (NumberFormatException e) {
            // Tratar o erro ou lançar uma exceção apropriada
            throw new IllegalArgumentException("Preço inválido", e);
        }

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


    public ProdutoDTO saveDto(ProdutoDTO produtoDTO){
        Produto produto = this.fromDTO(produtoDTO);
        Produto produtoBd = produtoRepository.save(produto);
        return this.toDTO(produtoBd);
    }

    public List<Produto> getAll(){
        return produtoRepository.findAll();
    }

    public Optional<ProdutoDTO> getById(Long id){
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if(optionalProduto.isPresent()){
            return Optional.of(this.toDTO(optionalProduto.get()));
        }else {
            return Optional.empty();
        }
    }

    public Optional<ProdutoDTO> updateProduto(Long id, ProdutoDTO produtoDTO){
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if(optionalProduto.isPresent()){
            Produto produto = optionalProduto.get();
            produto.setNome(produtoDTO.getNome());
            produto.setPreco(Float.parseFloat(produtoDTO.getPreco()));
            produto.setQuantidade(produtoDTO.getQuantidade());

            Produto produtoUpdate = produtoRepository.save(produto);
            return Optional.of(this.toDTO(produtoUpdate));
        } else {
            return Optional.empty();
        }
    }

    public boolean delete(Long id){
        if(produtoRepository.existsById(id)){
            produtoRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }






}
