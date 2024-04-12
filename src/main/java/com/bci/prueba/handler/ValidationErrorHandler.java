package com.bci.prueba.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.List;
import com.bci.prueba.util.Error;

@ControllerAdvice
public class ValidationErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        String errores=fieldErrors.stream().map(e -> e.getField() + ":" + e.getDefaultMessage()+"; ").reduce("", String::concat);
        return ResponseEntity.badRequest().body(new Error(errores));
    }
}
