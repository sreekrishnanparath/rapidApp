package com.jst.rapidapp.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;

@RestControllerAdvice
public class ExceptionHandleController {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(),
                httpStatus,
                ZonedDateTime.now());
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Object> handleNoDataFoundException(NoDataFoundException noDataFoundException) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ExceptionResponse exceptionResponse = new ExceptionResponse("No Data Found",
                httpStatus,
                ZonedDateTime.now());
        return new ResponseEntity<>(exceptionResponse, httpStatus);
    }
}
