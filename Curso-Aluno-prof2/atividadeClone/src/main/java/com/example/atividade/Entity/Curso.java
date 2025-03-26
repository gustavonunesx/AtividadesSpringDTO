package com.example.atividade.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private int numeroSala;

    @OneToOne
    @JoinColumn(name = "IdProfessor", referencedColumnName =  "idProfessor")
    private Professor professor;

    //um curso para varios alunos (relação)   ---Cascade = quando deleta um a ligada vai junto
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Aluno> alunos;

    public Curso(){}

    public Curso(Long id, String nome, int numeroSala) {
        this.id = id;
        this.nome = nome;
        this.numeroSala = numeroSala;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }
}
