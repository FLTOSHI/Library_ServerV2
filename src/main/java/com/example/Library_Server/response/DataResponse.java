package com.example.Library_Server.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse <T> extends BaseResponse {
    private T data;

    public DataResponse(Boolean success, String message, T data){
        super(success, message);
        this.data = data;
    }
}
