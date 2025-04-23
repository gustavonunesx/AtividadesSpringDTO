package com.example.avl_cadastro.dto;


import com.example.avl_cadastro.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private String username;
    private String senha;
    private LocalDate dataNasc;

    public Usuario toUsuario(){
        return new Usuario(
                this.id,
                this.nome,
                this.sobrenome,
                this.cpf,
                this.email,
                this.username,
                this.senha,
                this.dataNasc
        );
    }

    public UsuarioDTO fromUsuario(Usuario usuario){
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getSobrenome(),
                usuario.getCpf(),
                usuario.getEmail(),
                usuario.getUsername(),
                usuario.getSenha(),
                usuario.getDataNasc()
        );
    }


}
