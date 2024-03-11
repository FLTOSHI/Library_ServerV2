package com.example.Library_Server.service;

import com.example.Library_Server.entity.PublisherEntity;
import com.example.Library_Server.repository.PublisherRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Validated
public class PublisherService {
    private final PublisherRepository repository;

    public List<PublisherEntity> findAll(){
        return repository.findAll();
    }

    public Optional<PublisherEntity> findById(Long id){
        return repository.findById(id);
    }

    public PublisherEntity save (@Valid PublisherEntity data){
        return repository.save(data);
    }

    public void update (PublisherEntity data){
        repository.save(data);
    }

    public void delete (Long id) {repository.deleteById(id);}
}
