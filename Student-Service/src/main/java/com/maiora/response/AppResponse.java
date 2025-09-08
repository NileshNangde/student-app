package com.maiora.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppResponse<T> {
    private String status;
    private String message;
    private T data;

    public static <T> AppResponse<T> success(T data) {
        return AppResponse.<T>builder()
                .status("SUCCESS")
                .message("Operation successful")
                .data(data)
                .build();
    }

    public static <T> AppResponse<T> failure(String message) {
        return AppResponse.<T>builder()
                .status("FAILURE")
                .message(message)
                .build();
    }
}
