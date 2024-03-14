package com.example.Library_Server.controller;

import com.example.Library_Server.entity.AuthorEntity;
import com.example.Library_Server.response.BaseResponse;
import com.example.Library_Server.response.DataResponse;
import com.example.Library_Server.response.ListResponse;
import com.example.Library_Server.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Авторы", description = "Позволяет управлять данными, связанными с авторами.")
@RestController
@RequestMapping("api/v1/author")
@AllArgsConstructor
public class AuthorController {
    private final AuthorService service;

    @Operation(summary = "Получить список всех авторов", description = "Позволяет получить список всех авторов в базе данных.")
    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(new ListResponse<AuthorEntity>(true, "Список авторов: ", service.findAll()));
    }

    @Operation(summary = "Найти автора по идентификатору", description = "Позволяет найти автора, используя его идентификатор (ID).")
    @GetMapping
    public ResponseEntity<BaseResponse> by_id(@RequestParam @Parameter(description = "Идентификатор автора") Long id) {
        try {
            return ResponseEntity.ok(
                    new DataResponse<AuthorEntity>(true, "Найден следующий автор", service.findById(id).orElseThrow()));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(
                    new BaseResponse(false, exception.getMessage()));
        }
    }

    @Operation(summary = "Сохранить автора", description = "Позволяет сохранить информацию о авторе.")
    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody @Parameter(description = "Автор") AuthorEntity author) {
        try {
            return ResponseEntity.ok(new DataResponse<AuthorEntity>(true, "Автор сохранён.", service.save(author)));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }

    @Operation(summary = "Обновить автора", description = "Позволяет обновлять информацию о авторе.")
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody @Parameter(description = "Автор") AuthorEntity author) {
        try {
            service.update(author);
            return ResponseEntity.ok(new BaseResponse(true, "Автор сохранён."));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }

    @Operation(summary = "Удалить автора", description = "Позволяет удалить автора из базы данных, используя его идентификатор (ID).")
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable @Parameter(description = "Идентификатор автора") Long id) {
        try {
            return ResponseEntity.ok(new BaseResponse(true, "Автор удалён"));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }
}
