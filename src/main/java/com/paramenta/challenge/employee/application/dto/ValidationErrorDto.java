package com.paramenta.challenge.employee.application;

import java.time.LocalDateTime;
import java.util.Map;

public record ValidationErrorDto(
    String message,
    LocalDateTime timestamp,
    Map<String, String> errors
) {
    public ValidationErrorDto(String message, Map<String, String> errors) {
        this(message, LocalDateTime.now(), errors);
    }
}
