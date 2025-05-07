package com.beeorg.mymarketing.dto.http;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseBody<T> {

    private boolean error;

    private T body;
}