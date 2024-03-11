package com.example.Library_Server.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class BaseResponse {
    protected Boolean success;
    protected String message;
}
