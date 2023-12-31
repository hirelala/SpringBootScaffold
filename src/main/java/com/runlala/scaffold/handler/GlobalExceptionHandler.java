package com.runlala.scaffold.handler;

import com.runlala.scaffold.dto.R;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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

}