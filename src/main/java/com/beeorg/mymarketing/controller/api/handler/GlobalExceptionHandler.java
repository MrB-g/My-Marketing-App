package com.beeorg.mymarketing.controller.api.handler;

import com.beeorg.mymarketing.dto.lib.ExceptionDto;
import com.beeorg.mymarketing.dto.http.ErrorResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception e) {
        String errorMessage = e.getMessage();
        ExceptionDto exceptionData = ExceptionDto.builder().message(errorMessage).build();
        ErrorResponseBody<ExceptionDto> errorResponseBody = new ErrorResponseBody<>(true, exceptionData);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseBody);
    }
}
