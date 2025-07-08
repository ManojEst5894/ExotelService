package com.Zuora.SerivceLayer.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
    // --- CRITICAL CHANGE HERE ---
    private Map<String, List<String>> errors; // Changed to Map<String, List<String>>


    // Constructor for general errors
    public ErrorResponse(int status, String error, String message, String path) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    // Constructor for validation errors - type of 'errors' parameter updated
    public ErrorResponse(int status, String error, String message, String path, Map<String, List<String>> errors) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.errors = errors; // Assign the map of field errors
    }

    // Existing constructor (no change needed here as it doesn't involve 'errors' map)
    public ErrorResponse(LocalDateTime timestamp, int status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    // Lombok's @Data will handle the getters and setters for the updated 'errors' field automatically.
    // If you were not using @Data, you would need to manually update getErrors() and setErrors() methods.
}