package com.example.atividadeBiblioteca.controller;

import com.example.atividadeBiblioteca.dto.EmprestimoDTORequest;
import com.example.atividadeBiblioteca.dto.EmprestimoDTOResponse;
import com.example.atividadeBiblioteca.entity.Emprestimo;
import com.example.atividadeBiblioteca.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;


    @GetMapping
    public ResponseEntity<List<Emprestimo>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(emprestimoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoDTOResponse> getById(@PathVariable  Long id){
        Optional<EmprestimoDTOResponse> cursoDTO = emprestimoService.getById(id);
        if(cursoDTO.isPresent()){
            return ResponseEntity.ok(cursoDTO.get());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<EmprestimoDTOResponse> created(@RequestBody EmprestimoDTORequest emprestimoDTORequest){
        EmprestimoDTOResponse emprestimo = emprestimoService.saveDto(emprestimoDTORequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(emprestimo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmprestimoDTOResponse> update(@PathVariable Long id, @RequestBody EmprestimoDTORequest emprestimoDTORequest){
        Optional<EmprestimoDTOResponse> emprestimoDTOResponse = emprestimoService.updateEmprestimo(id, emprestimoDTORequest);
        if (emprestimoDTOResponse.isPresent()){
            return ResponseEntity.ok(emprestimoDTOResponse.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(emprestimoService.delete(id)){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
