package com.swedq.vehicle.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class RestFulException extends RuntimeException {
    private Map<String, Object> properties;
    private Integer errorCode;
    private String errorMessage;

    public RestFulException(Integer errorCode,String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public RestFulException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

}