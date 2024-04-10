package com.example.Library_Server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Schema(description = "Сущность жанра")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "genres")
public class GenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Идентификатор жанра", example = "1337")
    private Long id;
    @Schema(description = "Название жанра", example = "Научная фантастика")
    private String title;
    @JsonIgnore
    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    @Schema(description = "Книги этого жанра", example = "Каталог запчастей ВАЗ-2109")
    private List<BookEntity> books;
}
