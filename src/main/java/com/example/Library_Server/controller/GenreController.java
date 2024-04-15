package com.example.Library_Server.controller;

import com.example.Library_Server.entity.GenreEntity;
import com.example.Library_Server.service.GenreService;

import com.example.Library_Server.response.BaseResponse;
import com.example.Library_Server.response.DataResponse;
import com.example.Library_Server.response.ListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Жанры", description = "Позволяет управлять данными, связанными с жанрами")
@RestController
@RequestMapping("api/v1/genre")
@AllArgsConstructor
public class GenreController {
    private final GenreService service;

    @Operation(summary = "Получить список всех жанров", description = "Позволяет получить список всех жанров в базе данных.")
    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(new ListResponse<GenreEntity>(true, "Список жанров: ", service.findAll()));
    }

    @Operation(summary = "Найти жанр по идентификатору", description = "Позволяет найти жанр, используя его идентификатор (ID).")
    @GetMapping
    public ResponseEntity<BaseResponse> by_id(@RequestParam @Parameter(description = "Идентификатор жанра") Long id) {
        try {
            return ResponseEntity.ok(new DataResponse<GenreEntity>(true, "Найден следующий жанр: ", service.findById(id).orElseThrow()));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }

    @Operation(summary = "Сохранить жанр", description = "Позволяет сохранить информацию о жанре.")
    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody @Parameter(description = "Жанр") GenreEntity genre) {
        try {
            return ResponseEntity.ok(new DataResponse<GenreEntity>(true, "Жанр сохранён.", service.save(genre)));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }

    @Operation(summary = "Изменить жанр", description = "Позволяет обновлять информацию о жанре.")
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody @Parameter(description = "Жанр") GenreEntity genre) {
        try {
            service.update(genre);
            return ResponseEntity.ok(new BaseResponse(true, "Жанр сохранён."));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }

    @Operation(summary = "Удалить жанр", description = "Позволяет удалить жанр из базы данных, используя его идентификатор (ID).")
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(
                    new BaseResponse(true, "Жанр удален"));
        } catch (RuntimeException e) {
            return ResponseEntity.ok(
                    new BaseResponse(false, e.getMessage()));

        }
    }
}