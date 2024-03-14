package com.example.Library_Server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


import java.util.List;

@Schema (description = "Сущность города издательства")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cities")
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Идентификатор города", example = "420")
    private Long id;
    @Schema(description = "Название города", example = "Мирный")
    private String title;
    @JsonIgnore
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    @Schema(description = "Издательство", example = "Просвящение")
    private List<PublisherEntity> publisher;
}
