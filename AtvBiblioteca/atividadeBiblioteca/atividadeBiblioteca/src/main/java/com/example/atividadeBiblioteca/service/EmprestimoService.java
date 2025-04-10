package com.example.atividadeBiblioteca.service;

import com.example.atividadeBiblioteca.dto.EmprestimoDTORequest;
import com.example.atividadeBiblioteca.dto.EmprestimoDTOResponse;
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

    public Emprestimo fromDTO(EmprestimoDTORequest emprestimoDTORequest){
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setCliente(emprestimoDTORequest.getCliente());
        emprestimo.setData_final(emprestimoDTORequest.getData_final());

        return emprestimo;
    }

    public EmprestimoDTOResponse toDTO(Emprestimo emprestimo){
       EmprestimoDTOResponse emprestimoDTOResponse = new EmprestimoDTOResponse();
        emprestimoDTOResponse.setCliente(emprestimo.getCliente());
        emprestimoDTOResponse.setData_final(emprestimo.getData_final());

        return emprestimoDTOResponse;
    }

    public List<Emprestimo> getAll(){
        return emprestimoRepository.findAll();
    }

    public Optional<EmprestimoDTOResponse> getById(Long id){
        Optional<Emprestimo> optionalEmprestimo = emprestimoRepository.findById(id);
        if(optionalEmprestimo.isPresent()){// verifica se encontrou algum professor
            return Optional.of(this.toDTO(optionalEmprestimo.get()));
        }else {
            return Optional.empty(); // um objeto Optional vazio.
        }

    }

    public EmprestimoDTOResponse saveDto(EmprestimoDTORequest emprestimoDTORequest){
        Emprestimo emprestimo = this.fromDTO(emprestimoDTORequest);
        Emprestimo emprestimoBd = emprestimoRepository.save(emprestimo);
        return this.toDTO(emprestimoBd);
    }

    public Optional<EmprestimoDTOResponse> updateEmprestimo(Long id, EmprestimoDTORequest emprestimoDTORequest){
        Optional<Emprestimo> optionalEmprestimo = emprestimoRepository.findById(id);
        if(optionalEmprestimo.isPresent()){
            Emprestimo emprestimo = optionalEmprestimo.get();
            emprestimo.setData_final(emprestimoDTORequest.getData_final());
            emprestimo.setData_inicial(emprestimoDTORequest.getData_inicial());


            Emprestimo emprestimoUpdate = emprestimoRepository.save(emprestimo);

            return Optional.of(this.toDTO(emprestimoUpdate));
        }else {
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
