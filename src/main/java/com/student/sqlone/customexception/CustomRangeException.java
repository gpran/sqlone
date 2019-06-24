package com.student.sqlone.customexception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.InputMismatchException;

@RestControllerAdvice
@ResponseStatus(value = HttpStatus.CONFLICT , reason = "Please Enter Integer values only in Range\n Age is at least 1 year\n Standard is between 1 to 12")
public class CustomRangeException {
    @ExceptionHandler(InputMismatchException.class)
    public final ResponseEntity<ErrorDetails> handleIntegerRangeException(InputMismatchException ex, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),

                request.getDescription(false));
        System.out.println(new Date()+"\t"+ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

    }
}
