package com.example.hotelmanager.exception;

import com.example.hotelmanager.config.AppConfig;
import com.example.hotelmanager.model.response.ResponseObject;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestControllerAdvice

public class GlobalExceptionHandler {
    private MessageSource messageSource;
   @Autowired
    private AppConfig appConfig;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseObject> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new ResponseObject(
                        500,
                        e.getMessage(),
                        null
                )
        );
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ResponseObject> handleNotFoundEntityException (BusinessException e , HttpServletRequest request) {
        Locale locale = appConfig.localeResolver().resolveLocale(request);

        String message = appConfig.messageSource().getMessage((e.getMessage()) , null , locale);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ResponseObject(
                        e.getResource().getCode(),
                        message,
                      null
                )
        );
    }
}
