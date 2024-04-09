package com.blog.exception;

import com.blog.utils.Result;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Result<String> handlerException(HttpServletResponse response, Exception e) {
        e.printStackTrace();
        response.setStatus(500);
        return Result.error(500, StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "系统错误");
    }
}
