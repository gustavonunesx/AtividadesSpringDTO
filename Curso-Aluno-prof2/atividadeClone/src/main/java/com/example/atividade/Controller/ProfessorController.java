package com.example.atividade.Controller;

import com.example.atividade.Entity.Professor;
import com.example.atividade.Entity.ProfessorDTO;
import com.example.atividade.services.ProfessorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ProfessorController {

    @Autowired
    private ProfessorServices professorServices;

    @PostMapping
    public ResponseEntity<Professor> created(@RequestBody ProfessorDTO professorDTQ){
        Professor professorBd = professorServices.save(professorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(professorBd);
    }




}
