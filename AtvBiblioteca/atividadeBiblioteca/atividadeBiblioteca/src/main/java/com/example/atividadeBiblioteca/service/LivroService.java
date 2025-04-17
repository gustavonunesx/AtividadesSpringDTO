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
    public LivroRepository livroRepository;

    public List<Livro> getAll() {
        return livroRepository.findAll();
    }

    public List<Livro> getAllByName(String nome){
        return livroRepository.findAllByNome(nome);
    }

    public Optional<LivroDTO> getById(Long id){
        Optional<Livro> livroOptional = livroRepository.findById(id);
        if(livroOptional.isPresent()){
            LivroDTO livroDTO = new LivroDTO();
            return Optional.of(livroDTO.fromLivro(livroOptional.get()));
        }else {
            return Optional.empty();
        }
    }

    public LivroDTO create(LivroDTO livroDTO){
        Livro livro = livroDTO.toLivro();
        livro = livroRepository.save(livro);
        return livroDTO.fromLivro(livro);
    }

    public Optional<LivroDTO> update(Long id, LivroDTO livroDTO){
        Optional<Livro> livroOptional = livroRepository.findById(id);
        if(livroOptional.isPresent()){
            Livro livro = livroOptional.get();
            livro.setNome(livroDTO.getNome());
            livro.setAutor(livroDTO.getAutor());
            livro.setIsbn(livroDTO.getIsbn());
            livro.setGenero(livro.getGenero());

            livro = livroRepository.save(livro);

            return Optional.of(livroDTO.fromLivro(livro));
        }else{
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
