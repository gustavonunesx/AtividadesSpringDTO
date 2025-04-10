package com.example.atividadeBiblioteca.service;

import com.example.atividadeBiblioteca.dto.LivroDTO;
import com.example.atividadeBiblioteca.entity.Livro;
import com.example.atividadeBiblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;


    public Livro fromDTO(LivroDTO livroDTO){
        Livro livro = new Livro();
        livro.setNome(livroDTO.getNome());
        livro.setEmprestimo(livroDTO.getEmprestimo());

        return livro;
    }

    public LivroDTO toDTO(Livro livro){
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setNome(livro.getNome());
        livroDTO.setEmprestimo(livro.getEmprestimo());


        return livroDTO;
    }

    public List<Livro> getAll(){
        return livroRepository.findAll();
    }

    public Optional<LivroDTO> getById(Long id){
        Optional<Livro> optionalLivro = livroRepository.findById(id);
        if(optionalLivro.isPresent()){
            return Optional.of(this.toDTO(optionalLivro.get()));
        }else {
            return Optional.empty();
        }

    }

    public LivroDTO saveDto(LivroDTO livroDTO){
        Livro livro = this.fromDTO(livroDTO);
        Livro livroBd = livroRepository.save(livro);
        return this.toDTO(livroBd);
    }

    public Optional<LivroDTO> updateLivro(Long id, LivroDTO livroDTO){
        Optional<Livro> optionalLivro = livroRepository.findById(id);
        if(optionalLivro.isPresent()){
            Livro livro= optionalLivro.get();
            livro.setEmprestimo(livroDTO.getEmprestimo());
            livro.setNome(livroDTO.getNome());


            Livro livroUpdate = livroRepository.save(livro);

            return Optional.of(this.toDTO(livroUpdate));
        }else {
            return Optional.empty();
        }
    }

    public boolean delete(Long id){
        if(livroRepository.existsById(id)){
            livroRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }



}
