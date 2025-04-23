package com.example.avl_cadastro.repository;

import com.example.avl_cadastro.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findAllByNome(String nome);
    Optional<Usuario> findByCpf(String cpf);
    Optional<Usuario> findBySenha(String senha);
}
