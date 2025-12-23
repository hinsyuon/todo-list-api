package com.example.todolistapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.todolistapi.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionalHandler {
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleTaskNotFound(TaskNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse<>(false, ex.getMessage(), null));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>(
                "Internal server error",
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
