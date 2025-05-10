package com.beeorg.mymarketing.service.handler;

import com.beeorg.mymarketing.service.implementation.ResponseEntityBuilderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.function.Function;

@Service
public class CrudEndpointHandler {

    public static <T, R> ResponseEntity<?> run(
            Function<T, R> function,
            T t,
            Errors validationErrors,
            ResponseEntityBuilderService<R> responseEntityBuilderService
    ) {
        if (validationErrors.hasErrors()) {
            return responseEntityBuilderService.error(validationErrors);
        }
        R response = function.apply(t);
        return responseEntityBuilderService.success(response);
    }
}