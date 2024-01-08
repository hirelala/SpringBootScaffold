package com.runlala.scaffold.handler;

import com.runlala.scaffold.dto.R;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
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
    public R<String> handleIllegalArgumentException(IllegalArgumentException e, HttpServletRequest request) {
        String requestUrl = request.getRequestURL().toString();
        if (requestUrl.contains("/api")) {
            log.error(e.getMessage(), e);
            return R.error(e.getMessage());
        }

        throw e;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public R<List<String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        String requestUrl = request.getRequestURL().toString();
        if (requestUrl.contains("/api")) {
            return R.error(
                    "Validate failed.",
                    e.getBindingResult().getFieldErrors().stream().map(f -> "[" + f.getField() + "] " + f.getDefaultMessage()).toList()
            );
        }

        throw new IllegalArgumentException(e);
    }

}