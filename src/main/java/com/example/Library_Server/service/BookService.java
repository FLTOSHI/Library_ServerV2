package com.example.Library_Server.service;

import com.example.Library_Server.entity.BookEntity;
import com.example.Library_Server.repo.BookRepo;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepo repo;
    public BookService(BookRepo repo) {
        this.repo = repo;
    }
    public void save(BookEntity book) {
        repo.save(book);
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
    public Iterable<BookEntity> getAll(){return repo.findAll();}
}
