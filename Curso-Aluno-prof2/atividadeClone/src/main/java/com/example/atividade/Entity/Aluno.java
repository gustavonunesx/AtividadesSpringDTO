package com.example.atividade.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idALuno;
    private String nome;
    private String sobrenome;

    @ManyToOne
    @JoinColumn(name = "id" , referencedColumnName = "id")
    @JsonBackReference
    private Curso curso;

    public Aluno(){}

    public Aluno(Long idALuno, String nome, String sobrenome) {
        this.idALuno = idALuno;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public Long getIdALuno() {
        return idALuno;
    }

    public void setIdALuno(Long idALuno) {
        this.idALuno = idALuno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
