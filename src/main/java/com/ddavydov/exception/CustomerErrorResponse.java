package com.ddavydov.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerErrorResponse {

    private int status;
    private String message;
    private long timestamp;
}
