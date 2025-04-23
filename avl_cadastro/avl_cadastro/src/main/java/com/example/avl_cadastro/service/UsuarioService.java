package com.example.avl_cadastro.service;


import com.example.avl_cadastro.dto.UsuarioDTO;
import com.example.avl_cadastro.entity.Usuario;
import com.example.avl_cadastro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsers(){
        return usuarioRepository.findAll();
    }

    //busca por id
    public Optional<UsuarioDTO> getById(Long id){
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if(usuarioOptional.isPresent()){
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            return Optional.of(usuarioDTO.fromUsuario(usuarioOptional.get()));
        }else {
            return Optional.empty();
        }
    }

    //busca por nome
    public List<Usuario> getByName(String nome){
        return usuarioRepository.findAllByNome(nome);
    }

    //busca por cpf
    public Optional<Usuario> getByCpf(String cpf){
        return usuarioRepository.findByCpf(cpf);
    }

    public UsuarioDTO createUser(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioDTO.toUsuario();
        usuario = usuarioRepository.save(usuario);
        return usuarioDTO.fromUsuario(usuario);
    }

    public Optional<UsuarioDTO> updateUser(Long id, UsuarioDTO usuarioDTO){
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if(optionalUsuario.isPresent()){
            Usuario usuario = optionalUsuario.get();
            usuario.setNome(usuarioDTO.getNome());
            usuario.setSobrenome(usuarioDTO.getSobrenome());
            usuario.setCpf(usuarioDTO.getCpf());
            usuario.setEmail(usuarioDTO.getEmail());
            usuario.setDataNasc(usuarioDTO.getDataNasc());

            usuario = usuarioRepository.save(usuario);

            return Optional.of(usuarioDTO.fromUsuario(usuario));
        }else{
            return Optional.empty();
        }
    }

    public Optional<UsuarioDTO> updateSenha(Long id, UsuarioDTO usuarioDTO){
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if(optionalUsuario.isPresent()){
            Usuario usuario = optionalUsuario.get();
            usuario.setSenha(usuarioDTO.getSenha());

            usuario = usuarioRepository.save(usuario);

            return Optional.of(usuarioDTO.fromUsuario(usuario));
        }else{
            return Optional.empty();
        }
    }

    //deletar usuario
    public boolean delete(Long id){
        if(usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }


    }


