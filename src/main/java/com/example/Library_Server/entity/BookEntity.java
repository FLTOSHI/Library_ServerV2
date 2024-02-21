package com.example.Library_Server.entity;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "books")
public class BookEntity {
    @Column(name = "book_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    private String author;
    private String publishing;
    private Integer year;
    private String kind;
}
