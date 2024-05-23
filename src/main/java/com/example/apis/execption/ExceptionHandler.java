package com.example.apis.execption;

import com.example.apis.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<Object> handleException(DuplicateEmailException exception) {
        return ResponseUtil.returnResponse(exception);
    }
}
