package com.example.todolistapi.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "result", "message", "data" })
public class ApiResponse<T> {

    @JsonProperty("result")
    private Boolean result;
    @JsonProperty("message")
    private String message;
    @JsonProperty("data")
    private T data;

    public ApiResponse(Boolean result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }
    public ApiResponse(Boolean result, String message) {
        this.result = result;
        this.message = message;
        this.data = null;
    }
    public ApiResponse(String message) {
        this.result = true;
        this.message = message;
        this.data = null;
    }
    public ApiResponse(String message, T data) {
        this.result = true;
        this.message = message;
        this.data = data;
    }
}

