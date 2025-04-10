package com.example.atividadeBiblioteca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Emprestimo {

    private Long idEmprestimo;
    private LocalDate data_inicial;
    private LocalDate data_final;


    @OneToMany(mappedBy = "emprestimo", cascade = CascadeType.ALL)
    private List<Livro> livro;

    @OneToOne
    @JoinColumn(name = "idCliente" , referencedColumnName = "idCliente")
    private Cliente cliente;



}
