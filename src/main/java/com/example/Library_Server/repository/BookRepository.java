package com.example.Library_Server.repository;

import com.example.Library_Server.entity.BookEntity;
import com.example.Library_Server.response.ListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findDistinctByPublisher_TitleOrPublisherCity (String title, String city);
}
