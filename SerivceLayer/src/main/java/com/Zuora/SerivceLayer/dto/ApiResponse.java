package com.Zuora.SerivceLayer.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {
	private boolean success;
	private String message;
	private T data; // Generic type for the actual response data
	private LocalDateTime timestamp;

	public ApiResponse(boolean success, String message, T data) {
		this.success = success;
		this.message = message;
		this.data = data;
		this.timestamp = LocalDateTime.now();
	}

	public ApiResponse(boolean success, String message) {
		this(success, message, null); // Constructor for responses without data

	}

	@JsonIgnore
	public HttpStatus getStatusCode() {
		return this.success ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
	}


}