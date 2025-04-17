package com.example.atividadeBiblioteca.dto;

import com.example.atividadeBiblioteca.entity.Cliente;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO implements Serializable {

    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;

    public Cliente toCliente(){
        return new Cliente(
                this.id,
                this.nome,
                this.sobrenome,
                this.cpf
        );
    }

    public ClienteDTO fromCliente(Cliente cliente){
        return new ClienteDTO(
                cliente.getIdCliente(),
                cliente.getNome(),
                cliente.getSobrenome(),
                cliente.getCpf()

        );
    }

}
