package com.example.Library_Server.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


import java.util.List;

@Schema (description = "Сущность книги")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Идентификатор книги", example = "743")
    private Long id;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "author_id")
    @Schema(description = "Идентификатор автора", example = "241")
    private AuthorEntity author;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @Schema(description = "Идентификатор издательства", example = "862")
    private PublisherEntity publisher;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "genre_id")
    @Schema(description = "Жанр", example = "Ужасы")
    private GenreEntity genre;
    @Schema(description = "Год выпуска книги", example = "2007")
    private String year;
}
