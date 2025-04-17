package com.example.atividadeBiblioteca.service;

import com.example.atividadeBiblioteca.dto.EmprestimoDTO;
import com.example.atividadeBiblioteca.entity.Emprestimo;
import com.example.atividadeBiblioteca.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public List<Emprestimo> getAllEmprestimos() {
        return emprestimoRepository.findAll();
    }

    public Optional<EmprestimoDTO> getById(Long id){
        Optional<Emprestimo> emprestimoOptional = emprestimoRepository.findById(id);
        if(emprestimoOptional.isPresent()){
            EmprestimoDTO emprestimoDTO = new EmprestimoDTO();
            return Optional.of(emprestimoDTO.fromEmprestimo(emprestimoOptional.get()));
        }else {
            return Optional.empty();
        }
    }

    public EmprestimoDTO create(EmprestimoDTO emprestimoDTO){
        Emprestimo emprestimo = emprestimoDTO.toEmprestimo();
        emprestimo = emprestimoRepository.save(emprestimo);
        return emprestimoDTO.fromEmprestimo(emprestimo);
    }

    public Optional<EmprestimoDTO> update(Long id, EmprestimoDTO emprestimoDTO){
        Optional<Emprestimo> emprestimoOptional = emprestimoRepository.findById(id);
        if(emprestimoOptional.isPresent()){
            Emprestimo emprestimo = emprestimoOptional.get();
            emprestimo.setData_inicial(emprestimoDTO.getData_inicial());
            emprestimo.setData_final(emprestimoDTO.getData_final());
            emprestimo.setCliente(emprestimoDTO.getCliente());
            emprestimo.setLivros(emprestimoDTO.getLivros());

            emprestimo = emprestimoRepository.save(emprestimo);

            return Optional.of(emprestimoDTO.fromEmprestimo(emprestimo));
        }else{
            return Optional.empty();
        }
    }

    public boolean delete(Long id){
        if(emprestimoRepository.existsById(id)){
            emprestimoRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}



