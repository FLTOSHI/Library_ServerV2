package com.example.Library_Server.repo;

import com.example.Library_Server.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<BookEntity, Long> {
}
