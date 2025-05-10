package com.beeorg.mymarketing.controller.api.handler;

import com.beeorg.mymarketing.dto.enums.ResponseBodyStatusEnum;
import com.beeorg.mymarketing.dto.http.ResponseBody;
import com.beeorg.mymarketing.dto.lib.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception e) {
        String errorMessage = e.getMessage();
        List<ErrorDto> exceptionData = List.of(ErrorDto.builder().errorMessage(errorMessage).build());
        ResponseBody<ErrorDto> responseBody = new ResponseBody<>(ResponseBodyStatusEnum.ERROR, exceptionData);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }
}
