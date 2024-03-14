package com.example.Library_Server.controller;

import com.example.Library_Server.entity.BookEntity;
import com.example.Library_Server.entity.PublisherEntity;
import com.example.Library_Server.response.BaseResponse;
import com.example.Library_Server.response.DataResponse;
import com.example.Library_Server.response.ListResponse;
import com.example.Library_Server.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Книги", description = "Позволяет управлять данными, связанными с книгами.")
@RestController
@RequestMapping("api/v1/book")
@AllArgsConstructor
public class BookController {
    private final BookService service;


    @Operation(summary = "Получить список всех книг", description = "Позволяет получить список всех книг.")
    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(new ListResponse<BookEntity>(true, "Список книг: ", service.findAll()));
    }

    @Operation(summary = "Найти по идентификатору", description = "Позволяет найти книгу по идентификатору (ID).")
    @GetMapping
    public ResponseEntity<BaseResponse> by_id(@RequestParam @Parameter(description = "Идентификатор книги") Long id) {
        try {
            return ResponseEntity.ok(new DataResponse<BookEntity>(true, "Найдена следующая книга: ", service.findById(id).orElseThrow()));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }


    @GetMapping("/publish")
    public ResponseEntity<BaseResponse> getPublisher(@RequestParam String title, @RequestParam String city){
        return ResponseEntity.ok(new ListResponse<BookEntity>(service.getPublisher(title, city)));
    }

    @Operation(summary = "Сохранить книгу", description = "Позволяет сохранить информацию о книге.")
    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody @Parameter(description = "Книга") BookEntity book) {
        try {
            return ResponseEntity.ok(new DataResponse<BookEntity>(true, "Книга сохранена.", service.save(book)));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }

    @Operation(summary = "Обновить книгу", description = "Позволяет обновить информацию о книге.")
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody @Parameter(description = "Книга") BookEntity book) {
        try {
            service.update(book);
            return ResponseEntity.ok(new BaseResponse(true, "Книга сохранена."));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }

    @Operation(summary = "Удалить книгу", description = "Позволяет удалить книгу из базы.")
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete (@PathVariable @Parameter(description = "Идентификатор книги") Long id){
        try {
            return ResponseEntity.ok(new BaseResponse(true, "Книга удалена"));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }
}
