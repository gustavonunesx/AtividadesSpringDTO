package com.example.integracao.controller;

import com.example.integracao.DTO.ProdutoDTO;
import com.example.integracao.entity.Produto;
import com.example.integracao.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "http://localhost:5500") // Permite requisições do front-end
public class produtoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoDTO> created(@RequestBody ProdutoDTO produtoDTO){
        ProdutoDTO produto = produtoService.saveDto(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getById(@PathVariable Long id){
        Optional<ProdutoDTO> produtoDTO =produtoService.getById(id);
        if(produtoDTO.isPresent()){
            return ResponseEntity.ok(produtoDTO.get());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        //outra opcao alem de isPresent
        //return alunoDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> update(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO){
        Optional<ProdutoDTO> produtoDTOOptional = produtoService.updateProduto(id, produtoDTO);
        if (produtoDTOOptional.isPresent()){
            return ResponseEntity.ok(produtoDTOOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(produtoService.delete(id)){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }



}
