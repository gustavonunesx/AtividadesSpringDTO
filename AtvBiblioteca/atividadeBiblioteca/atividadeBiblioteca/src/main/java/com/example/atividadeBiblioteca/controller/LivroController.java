package com.example.atividadeBiblioteca.controller;

import com.example.atividadeBiblioteca.dto.LivroDTO;
import com.example.atividadeBiblioteca.entity.Livro;
import com.example.atividadeBiblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {

        @Autowired
        private LivroService livroService;

        @GetMapping
        public ResponseEntity<List<Livro>> getAll(){
            return ResponseEntity.status(HttpStatus.OK).body(livroService.getAll());
        }

        @GetMapping("/{id}")
        public ResponseEntity<LivroDTO> getById(@PathVariable Long id){
            Optional<LivroDTO> livroDTO = livroService.getById(id);
            if(livroDTO.isPresent()){
                return ResponseEntity.ok(livroDTO.get());
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }


        }

        @PostMapping
        public ResponseEntity<LivroDTO> created(@RequestBody LivroDTO livroDTO){
            LivroDTO livro = livroService.saveDto(livroDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(livro);
        }

        @PutMapping("/{id}")
        public ResponseEntity<LivroDTO> update(@PathVariable Long id, @RequestBody LivroDTO livroDTO){
            Optional<LivroDTO> optionalLivroDTO = livroService.updateLivro(id, livroDTO);
            if (optionalLivroDTO.isPresent()){
                return ResponseEntity.ok(optionalLivroDTO.get());
            }else {
                return ResponseEntity.notFound().build();
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@PathVariable Long id){
            if(livroService.delete(id)){
                return ResponseEntity.noContent().build();
            }else {
                return ResponseEntity.notFound().build();
            }
        }


}
