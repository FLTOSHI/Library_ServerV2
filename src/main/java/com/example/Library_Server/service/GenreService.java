package com.example.Library_Server.service;

import com.example.Library_Server.entity.GenreEntity;
import com.example.Library_Server.repository.GenreRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
public class GenreService {
    private final GenreRepository repository;

    public List<GenreEntity> findAll(){
        return repository.findAll();
    }

    public Optional<GenreEntity> findById(Long id){
        return repository.findById(id);
    }

    public GenreEntity save (@Valid GenreEntity data){
        return repository.save(data);
    }

    public void update (GenreEntity data){
        repository.save(data);
    }

    public void delete (Long id) {repository.deleteById(id);}
}

