package com.example.apis.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    public static ResponseEntity<Object> returnResponse(RuntimeException exception) {
        StatusDto statusDto = new StatusDto();
        statusDto.setCode(HttpStatus.BAD_REQUEST);
        statusDto.setMessage(exception.getMessage());
        exception.printStackTrace();
        return new ResponseEntity<>(statusDto, HttpStatus.OK);
    }
}
