package com.example.atividadeBiblioteca.dto;

import com.example.atividadeBiblioteca.entity.Cliente;
import com.example.atividadeBiblioteca.entity.Emprestimo;
import com.example.atividadeBiblioteca.entity.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoDTO {

    private Long id;
    private LocalDate data_inicial;
    private LocalDate data_final;
    private Cliente cliente;
    private List<Livro> livros;


    public Emprestimo toEmprestimo(){
        return new Emprestimo(
                this.id,
                this.data_inicial,
                this.data_final,
                this.getCliente(),
                this.livros
        );
    }

    public EmprestimoDTO fromEmprestimo(Emprestimo emprestimo){
        return new EmprestimoDTO(
                emprestimo.getIdEmprestimo(),
                emprestimo.getData_inicial(),
                emprestimo.getData_final(),
                emprestimo.getCliente(),
                emprestimo.getLivros()
        );
    }

}
