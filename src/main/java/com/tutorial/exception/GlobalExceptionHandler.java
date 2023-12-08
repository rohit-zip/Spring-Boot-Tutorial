package com.tutorial.exception;

import com.tutorial.dto.ErrorDto;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Tutorial
 * Package - com.tutorial.exception
 * Created_on - 08 December-2023
 * Created_at - 20 : 31
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErrorDto> handleDefaultHandlerExceptionResolver(MethodArgumentNotValidException exception) {
        List<ErrorDto> errorList = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getFieldErrors();
        for (FieldError error : fieldErrors) { // Password, Name
            String field = error.getField();
            String defaultMessage = error.getDefaultMessage();
            ErrorDto errorDto = new ErrorDto();
            errorDto.setField(field);
            errorDto.setMessage(defaultMessage);
            errorList.add(errorDto);
        }
        return errorList;
    }
}
