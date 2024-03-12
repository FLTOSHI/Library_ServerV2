package com.example.Library_Server.controller;

import com.example.Library_Server.entity.BookEntity;
import com.example.Library_Server.entity.PublisherEntity;
import com.example.Library_Server.response.BaseResponse;
import com.example.Library_Server.response.DataResponse;
import com.example.Library_Server.response.ListResponse;
import com.example.Library_Server.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/book")
@AllArgsConstructor
public class BookController {
    private final BookService service;

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(new ListResponse<BookEntity>(true, "Список книг: ", service.findAll()));
    }

    @GetMapping
    public ResponseEntity<BaseResponse> by_id(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(new DataResponse<BookEntity>(true, "Найдена следующая книга: ", service.findById(id).orElseThrow()));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }

//    @GetMapping()
//    public ResponseEntity<BaseResponse> getPublisher(@RequestParam String title, @RequestParam String city){
//        return ResponseEntity.ok(new ListResponse<PublisherEntity>(service.getPublisher)
//    }

    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody BookEntity book) {
        try {
            return ResponseEntity.ok(new DataResponse<BookEntity>(true, "Книга сохранена.", service.save(book)));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }

    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody BookEntity book) {
        try {
            service.update(book);
            return ResponseEntity.ok(new BaseResponse(true, "Книга сохранена."));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete (@PathVariable Long id){
        try {
            return ResponseEntity.ok(new BaseResponse(true, "Книга удалена"));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }
}
