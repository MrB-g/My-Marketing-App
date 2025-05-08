package com.beeorg.mymarketing.dto.http;

import lombok.Data;

@Data
public class ResponseBody<T> {

    private String status;

    private T data;

    public ResponseBody(ResponseBodyStatusEnum status, T data) {
        this.status = status.name();
        this.data = data;
    }
}