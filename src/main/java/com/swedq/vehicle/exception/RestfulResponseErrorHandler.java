package com.swedq.vehicle.exception;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RestfulResponseErrorHandler implements org.springframework.web.client.ResponseErrorHandler{
    private ResponseErrorHandler errorHandler = new DefaultResponseErrorHandler();

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return errorHandler.hasError(response);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        Map<String, Object> properties = new HashMap<>();
        properties.put("code", response.getRawStatusCode());
        properties.put("header", response.getHeaders());

        RestFulException restFulException = new RestFulException(response.getRawStatusCode(), response.getStatusCode().getReasonPhrase());
        restFulException.setProperties(properties);

        throw restFulException;
    }
}