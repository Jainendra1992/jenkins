package com.MangemenSystem.SchoolSystem.exceptions;

import com.MangemenSystem.SchoolSystem.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Map<Object, Object>>> handleGenericException(Exception exception){
        ApiResponse<Map<Object, Object>> apiResponse = new ApiResponse<>("Error", "Something went wrong", Collections.emptyMap());

        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleValidationException(MethodArgumentNotValidException exception){
       Map<String,String> errors = new HashMap<>();
//        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
//        for(FieldError fieldError : fieldErrors){
//            errors.put(fieldError.getField(),fieldError.getDefaultMessage());
//        }

        exception.getBindingResult().getFieldErrors().forEach((fieldError) ->errors.put(fieldError.getField(),fieldError.getDefaultMessage()));


        ApiResponse<Map<String, String>> mapApiResponse = new ApiResponse<>("Error", "Validation Failed", errors);

      return  new ResponseEntity<>(mapApiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Map<Object, Object>>> ResourceNotFoundException(ResourceNotFoundException exception){
        ApiResponse<Map<Object, Object>> apiResponse = new ApiResponse<>("Error", exception.getMessage(), Collections.emptyMap());

       return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);

    }




}
