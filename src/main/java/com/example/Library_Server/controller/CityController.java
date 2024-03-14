package com.example.Library_Server.controller;

import com.example.Library_Server.entity.CityEntity;
import com.example.Library_Server.service.CityService;

import com.example.Library_Server.response.BaseResponse;
import com.example.Library_Server.response.DataResponse;
import com.example.Library_Server.response.ListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Города издательств", description = "Позволяет управлять данными, связанными с городами издательств.")
@RestController
@RequestMapping("api/v1/city")
@AllArgsConstructor
public class CityController {
    private final CityService service;

    @Operation(summary = "Получить список всех городов", description = "Позволяет получить список всех городов с издательствами в базе данных.")
    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(new ListResponse<CityEntity>(true, "Список городов: ", service.findAll()));
    }

    @Operation(summary = "Найти город издательства по идентификатору", description = "Позволяет найти город издательства, используя его идентификатор (ID).")
    @GetMapping
    public ResponseEntity<BaseResponse> by_id(@RequestParam @Parameter(description = "Идентификатор города") Long id) {
        try {
            return ResponseEntity.ok(new DataResponse<CityEntity>(true, "Найден следующий город: ", service.findById(id).orElseThrow()));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }

    @Operation(summary = "Сохранить город издательства", description = "Позволяет сохранить информацию о городе издательства.")
    @PostMapping
    public ResponseEntity<BaseResponse> save(@RequestBody @Parameter(description = "Город") CityEntity city) {
        try {
            return ResponseEntity.ok(new DataResponse<CityEntity>(true, "Город сохранён.", service.save(city)));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }

    @Operation(summary = "Обновить город издательства", description = "Позволяет обновлять информацию о городе издательства.")
    @PutMapping
    public ResponseEntity<BaseResponse> update(@RequestBody @Parameter(description = "Город") CityEntity city) {
        try {
            service.update(city);
            return ResponseEntity.ok(new BaseResponse(true, "Город сохранён."));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }

    @Operation(summary = "Удалить город", description = "Позволяет удалить город издательства из базы данных, используя его идентификатор (ID).")
    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> delete (@PathVariable @Parameter(description = "Идентификатор города") Long id){
        try {
            return ResponseEntity.ok(new BaseResponse(true, "Город удалён"));
        } catch (RuntimeException exception) {
            return ResponseEntity.ok(new BaseResponse(false, exception.getMessage()));
        }
    }
}