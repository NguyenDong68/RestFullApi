package com.example.restfulapi.exception;

public class DuplicateRecordException extends RuntimeException {
    public DuplicateRecordException(String message) {
        super(message); //•super() được sử dụng để triệu hồi lớp Constructor của lớp cha gần nhất.
    }

}
