package com.ggumtle.ggumtle.shared.response;

import com.ggumtle.ggumtle.shared.error.ErrorProperty;
import lombok.Getter;

@Getter
public class ErrorResponse {

    private String code;
    private String message;

    public ErrorResponse(ErrorProperty errorProperty, String message) {
        this.code = errorProperty.name();
        this.message = message;
    }

    public ErrorResponse(ErrorProperty errorProperty) {
        this.code = errorProperty.name();
        this.message = errorProperty.getMessage();
    }
}