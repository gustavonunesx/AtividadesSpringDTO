package com.example.atividadeBiblioteca.dto;

import com.example.atividadeBiblioteca.entity.Emprestimo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivroDTO {

    private Long id;
    private String nome;
    private String autor;
    private Long isbn;
    private String genero;
    @JsonIgnoreProperties("livros")
    private Emprestimo emprestimo;





}
