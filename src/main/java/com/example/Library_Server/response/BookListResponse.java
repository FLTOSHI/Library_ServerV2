package com.example.Library_Server.response;

import com.example.Library_Server.entity.BookEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BookListResponse extends BaseResponse {
    public BookListResponse(Iterable<BookEntity> data){
        super(true, "Книги");
        this.data = data;
    }

    private Iterable<BookEntity> data;
}
