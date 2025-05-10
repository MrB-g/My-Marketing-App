package com.beeorg.mymarketing.service.builder;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
public interface ResponseEntityBuilderService<T> {

    ResponseEntity<?> success(T data);

    ResponseEntity<?> error(Errors data);
}
