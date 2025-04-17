package com.example.atividadeBiblioteca.dto;


import com.example.atividadeBiblioteca.entity.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivroDTO implements Serializable {

    private Long id;
    private String nome;
    private String autor;
    private Long isbn;
    private String genero;

    public Livro toLivro(){
        return new Livro(
                this.id,
                this.nome,
                this.autor,
                this.isbn,
                this.genero
        );
    }

    public LivroDTO fromLivro(Livro livro){
        return new LivroDTO(
                livro.getIdLivro(),
                livro.getNome(),
                livro.getAutor(),
                livro.getIsbn(),
                livro.getGenero()
        );
    }




}
