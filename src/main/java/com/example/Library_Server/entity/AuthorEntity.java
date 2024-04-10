package com.example.Library_Server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@Schema (description = "Сущность автора")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authors")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Идентификатор автора", example = "241")
    private Long id;
    @NotBlank()
    @Pattern(regexp = "[А-Я][а-я]{1,20}")
    @Schema (description = "Фамилия автора", example = "Пушкин")
    private String lastname;
    @NotBlank
    @Pattern(regexp = "[А-Я][а-я]{1,20}")
    @Schema (description = "Имя автора", example = "Александр")
    private String name;
    @NotBlank
    @Pattern(regexp = "[А-Я][а-я]{1,20}")
    @Schema (description = "Отчество автора", example = "Сергеевич")
    private String surname;
    @JsonIgnore
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @Schema (description = "Книги, написанные этим автором", example = "Руслан и Людмила")
    private List<BookEntity> books;
}
