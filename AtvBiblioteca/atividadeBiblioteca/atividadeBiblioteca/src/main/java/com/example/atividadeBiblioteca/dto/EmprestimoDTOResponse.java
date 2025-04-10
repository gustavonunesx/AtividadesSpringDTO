package com.example.atividadeBiblioteca.dto;

import com.example.atividadeBiblioteca.entity.Cliente;
import com.example.atividadeBiblioteca.entity.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoDTOResponse {

    private Long id;
    private LocalDate data_inicial;
    private LocalDate data_final;
    private Cliente cliente;
    private List<Livro> livros;


}
