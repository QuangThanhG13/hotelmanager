package com.example.hotelmanager.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private final Resource resource;

    public BusinessException(Resource resource) {
        super(resource.getMessage());
        this.resource = resource;
    }
}
