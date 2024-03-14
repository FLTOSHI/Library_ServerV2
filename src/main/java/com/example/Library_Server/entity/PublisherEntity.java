package com.example.Library_Server.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Schema(description = "Сущность издательства")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "publishers")
public class PublisherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Идентификатор жанра", example = "360")
    private Long id;
    @Schema(description = "Название издательства", example = "Просвящение")
    private String title;
    @ManyToOne
    @JoinColumn(name = "city_id")
    @Schema(description = "Идентификатор города, в котором находится издательство", example = "420")
    private CityEntity city;
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    @Schema(description = "Книги этого издательства", example = "Учебник алгебры, 7 класс.")
    private List<BookEntity> books;
}
