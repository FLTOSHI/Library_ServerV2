package com.example.Library_Server.service;

import com.example.Library_Server.entity.BookEntity;
import com.example.Library_Server.repository.BookRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository repository;

    public List<BookEntity> findAll(){
        return repository.findAll();
    }

    public Optional<BookEntity> findById(Long id){
        return repository.findById(id);
    }

    public BookEntity save (BookEntity data){
        return repository.save(data);
    }

    public void update (BookEntity data){
        repository.save(data);
    }

    public void delete (Long id) {repository.deleteById(id);}

    public List<BookEntity> getPublisher(String title, String city) {
        return repository.findDistinctByPublisher_TitleOrPublisherCity(title,city);
    }
}
