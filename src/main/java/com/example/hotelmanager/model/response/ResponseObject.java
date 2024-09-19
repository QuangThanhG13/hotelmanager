package com.example.hotelmanager.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseObject {

    private Integer code;
    private String message;
    private Object data;
}
