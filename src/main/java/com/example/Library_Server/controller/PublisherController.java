package com.example.Library_Server.controller;

import com.example.Library_Server.entity.PublisherEntity;
import com.example.Library_Server.service.PublisherService;

import com.example.Library_Server.response.BaseResponse;
import com.example.Library_Server.response.DataResponse;
import com.example.Library_Server.response.ListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Издательства", description = "Позволяет управлять данными, связанными с издательствами.")
@RestController
@RequestMapping("api/v1/publisher")
@AllArgsConstructor
public class PublisherController {
    private final PublisherService service;

    @Operation(summary = "Получить список всех издательств", description = "Позволяет получить список всех издательств в базе данных.")
    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(new ListResponse<PublisherEntity>(true, "Список издателей: ", service.findAll()));
    }

    @Operation(summary = "Найти издательство по идентификатору", description = "Позволяет найти издательство, используя его идентификатор (ID).")
    @GetMapping
    public ResponseEntity<BaseResponse> by_id(@RequestParam @Parameter(description = "Идентификатор издательства") Long id) {
        try {
            return ResponseEntity.ok(new DataResponse<PublisherEntity>(true, "Найден следующий издатель: ", service.findById(id).orElseThrow()));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }

    @Operation(summary = "Сохранить издательство", description = "Позволяет сохранить информацию о издательстве.")
    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody @Parameter(description = "Издательство") PublisherEntity publisher) {
        try {
            return ResponseEntity.ok(new DataResponse<PublisherEntity>(true, "Издатель сохранён.", service.save(publisher)));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }

    @Operation(summary = "Изменить издательство", description = "Позволяет редактировать информацию о издательстве.")
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody @Parameter(description = "Издательство") PublisherEntity publisher) {
        try {
            service.update(publisher);
            return ResponseEntity.ok(new BaseResponse(true, "Издатель сохранён."));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }

    @Operation(summary = "Удалить издательство", description = "Позволяет удалить издательство из базы данных с помощью его идентификатора (ID).")
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete (@PathVariable @Parameter(description = "Идентификатор издательства") Long id){
        try {
            return ResponseEntity.ok(new BaseResponse(true, "Издатель удалён"));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }
}
