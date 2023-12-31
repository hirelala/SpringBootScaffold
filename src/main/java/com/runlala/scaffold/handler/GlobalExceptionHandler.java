package com.runlala.scaffold.handler;

import com.runlala.scaffold.dto.R;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public R<String> handleIllegalArgumentException(IllegalArgumentException e, HttpServletRequest request) {
        String requestUrl = request.getRequestURL().toString();
        if (requestUrl.contains("/api")) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }

        throw e;
    }

}