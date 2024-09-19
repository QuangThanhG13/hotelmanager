package com.example.hotelmanager.exception;

import lombok.Getter;

@Getter
public enum Resource {
    ROOM_ID_NOT_FOUND(1000, "room.not.found"),

    ROOM_TYPE_NOT_FOUND(2000, "Room Type not found");

    private final Integer code;
    private final String message;

    Resource(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

//bài toán ở header key access langes