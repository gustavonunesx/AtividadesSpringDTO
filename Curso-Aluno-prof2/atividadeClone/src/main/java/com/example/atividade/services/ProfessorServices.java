package com.example.atividade.services;

import com.example.atividade.Entity.Professor;
import com.example.atividade.Entity.ProfessorDTO;
import com.example.atividade.Repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class ProfessorServices {

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor fromDTQ (ProfessorDTO professorDTQ){
        Professor professor = new Professor();
        professor.setNome(professorDTQ.getNome());
        professor.setCpf(professorDTQ.getCpf());

        return professor;
    }

    public Professor save (ProfessorDTO professorDTQ){
        Professor professor = this.fromDTQ(professorDTQ);
        Professor professorBd = professorRepository.save(professor);
        return professorBd;
    }


}
