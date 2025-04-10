package com.example.atividadeBiblioteca.dto;

import com.example.atividadeBiblioteca.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmprestimoDTORequest {

    private LocalDate data_inicial;
    private LocalDate data_final;
    private Cliente cliente;
}
