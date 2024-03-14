package com.example.Library_Server.repository;

import com.example.Library_Server.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findDistinctByPublisher_TitleOrPublisherCity (String title, String city);
}
