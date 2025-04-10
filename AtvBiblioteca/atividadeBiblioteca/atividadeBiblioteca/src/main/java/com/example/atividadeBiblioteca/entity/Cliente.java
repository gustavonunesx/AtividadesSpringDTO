package com.example.atividadeBiblioteca.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    private String nome;
    private String sobrenome;
    @Column(nullable = false, unique = true) // nao permite valor nulo e nem que se repita em outros
    private int cpf;

    // cascade = cascadeType.ALL faz com que quando um Emprestimo for deletado o cliente também seja deletado
    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Emprestimo emprestimo;






}
