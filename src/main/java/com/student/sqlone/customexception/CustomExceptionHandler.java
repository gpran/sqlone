package com.student.sqlone.customexception;
import java.util.Date;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
//import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "For ID Age and Standard Fields Please Enter Integer Only")
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    //@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "For Age and Standard Fields Please Enter Integer Only")
    //@ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidFormatException.class)
    public final ResponseEntity<ErrorDetails> handleInvalidFormatException(InvalidFormatException ex, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),

                request.getDescription(false));
                System.out.println(new Date()+"\t"+ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

    }
    /*
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public final ResponseEntity<ErrorDetails> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),

                request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

    }
    */
}
