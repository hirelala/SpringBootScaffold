package com.runlala.scaffold.handler;

import com.runlala.scaffold.dto.Error;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ResponseEntity<Error> handleIllegalArgumentException(IllegalArgumentException e, HttpServletRequest request) {
        String requestUrl = request.getRequestURL().toString();
        if (requestUrl.contains("/api")) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(Error.of(List.of(e.getMessage())), HttpStatus.BAD_REQUEST);
        }

        throw e;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<Error> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        String requestUrl = request.getRequestURL().toString();
        if (requestUrl.contains("/api")) {
            List<String> messages = e.getBindingResult().getFieldErrors().stream().map(f -> "[" + f.getField() + "] " + f.getDefaultMessage()).toList();
            return new ResponseEntity<>(Error.of(messages), HttpStatus.BAD_REQUEST);
        }

        throw new IllegalArgumentException(e);
    }

}