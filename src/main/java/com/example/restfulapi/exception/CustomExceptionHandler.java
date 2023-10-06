package com.example.restfulapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice // cho phép trả về 1 view thay vì trả về cấu trúc JSON
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class) // dùng để chỉ rõ method xử lí exception nào
    @ResponseStatus(HttpStatus.NOT_FOUND) //Định nghĩa HTTP status trả về cho người dùng
        public ErrorResponse handlerNotFoundException(NotFoundException ex, WebRequest req) {
         return new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }
}
