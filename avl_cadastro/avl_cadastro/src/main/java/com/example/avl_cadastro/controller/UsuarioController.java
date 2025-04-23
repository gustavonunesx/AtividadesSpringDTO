package com.example.avl_cadastro.controller;

import com.example.avl_cadastro.dto.UsuarioDTO;
import com.example.avl_cadastro.entity.Usuario;
import com.example.avl_cadastro.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController  {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping
    public List<Usuario> getAll(){
        return usuarioService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getById(@PathVariable Long id){
        Optional<UsuarioDTO> usuarioDTOOptional = usuarioService.getById(id);
        if(usuarioDTOOptional.isPresent()){
            return ResponseEntity.ok(usuarioDTOOptional.get());
        } else {
        return ResponseEntity.notFound().build();
        }
    }

    //buscar por nome
    @GetMapping("/nome/{nome}")
    public List<Usuario> getAll(@PathVariable String nome) {
        if (nome != null && !nome.isEmpty()) {
            return usuarioService.getByName(nome);
        } else {
            return usuarioService.getAllUsers();
        }
    }

    //busca por cpf
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Usuario> getByCpf(@PathVariable String cpf){
        Optional<Usuario> usuarioDTOOptional = usuarioService.getByCpf(cpf);
        if(usuarioDTOOptional.isPresent()){
            return ResponseEntity.ok(usuarioDTOOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO usuarioDTOSave = usuarioService.createUser(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTOSave);
    }

    //att dados
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> update(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO){
        Optional<UsuarioDTO> usuarioDTOOptional = usuarioService.updateUser(id, usuarioDTO);
        if(usuarioDTOOptional.isPresent()){
            return ResponseEntity.ok(usuarioDTOOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{senha}")
    public ResponseEntity<UsuarioDTO> updateSenha(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO){
        Optional<UsuarioDTO> usuarioDTOOptional = usuarioService.updateSenha(id, usuarioDTO);
        if(usuarioDTOOptional.isPresent()){
            return ResponseEntity.ok(usuarioDTOOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
//a
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(usuarioService.delete(id)){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
