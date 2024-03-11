package com.example.Library_Server.repository;

import com.example.Library_Server.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
