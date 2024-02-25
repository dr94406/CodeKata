package com.example.sdjpa.dto.response;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record CommonResponse<T> (T status, String message) {

    public static CommonResponse commonResponse =
            CommonResponse.builder().
                    status(HttpStatus.OK).
                    message("정상 삭제").build();
}
