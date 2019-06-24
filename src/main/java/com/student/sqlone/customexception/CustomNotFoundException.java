package com.student.sqlone.customexception;

import java.util.Date;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Student Not Found By this ID")
public class CustomNotFoundException {
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public final ResponseEntity<ErrorDetails> handleStudentNotFoundException(EmptyResultDataAccessException ex, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),

                request.getDescription(false));
            System.out.println(new Date()+"\t"+ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

    }
}
