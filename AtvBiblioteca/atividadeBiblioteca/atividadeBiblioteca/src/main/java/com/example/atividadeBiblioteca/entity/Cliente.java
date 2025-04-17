package com.example.atividadeBiblioteca.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente implements Serializable { // ajuda converter obj em json

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    private String nome;
    private String sobrenome;
    @Column(nullable = false, unique = true) // nao permite valor nulo e nem que se repita em outros
    private String cpf;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private Set<Emprestimo> emprestimo; // estrutura Set tem o mesmo funcionamento do List, porém evitando a duplicidade de valores

    public Cliente(Long idCliente, String nome, String sobrenome, String cpf){
        this.idCliente = idCliente;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }






}
