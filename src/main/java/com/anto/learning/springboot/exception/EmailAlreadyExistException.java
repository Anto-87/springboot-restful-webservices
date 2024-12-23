package com.anto.learning.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmailAlreadyExistException extends Exception {

    private String message;

    public EmailAlreadyExistException(String message){
        super(message);
    }

}
