package com.beeorg.mymarketing.service.implementation;

import com.beeorg.mymarketing.dto.enums.ResponseBodyStatusEnum;
import com.beeorg.mymarketing.dto.http.ResponseBody;
import com.beeorg.mymarketing.dto.lib.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.List;

@Service
public class ResponseEntityBuilderService<T> implements com.beeorg.mymarketing.service.builder.ResponseEntityBuilderService<T> {

    private final ErrorValidationDtoBuilderService errorValidationDtoBuilderService;

    public ResponseEntityBuilderService(ErrorValidationDtoBuilderService errorValidationDtoBuilderService) {
        this.errorValidationDtoBuilderService = errorValidationDtoBuilderService;
    }

    @Override
    public ResponseEntity<?> success(T data) {
        List<T> dataList = List.of(data);
        ResponseBody<T> responseBody = new ResponseBody<>(ResponseBodyStatusEnum.SUCCESS, dataList);
        return ResponseEntity.ok(responseBody);
    }

    @Override
    public ResponseEntity<?> error(Errors data) {
        List<ErrorDto> errors = errorValidationDtoBuilderService.buildValidationDtoList(data);
        return ResponseEntity.badRequest().body(new ResponseBody<>(ResponseBodyStatusEnum.ERROR, errors));
    }
}
