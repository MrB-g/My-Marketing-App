package com.beeorg.mymarketing.dto.http;

import lombok.Data;

import java.util.List;

@Data
public class ResponseBody<T> {

    private String status;

    private List<T> data;

    public ResponseBody(ResponseBodyStatusEnum status, List<T> data) {
        this.status = status.name();
        this.data = data;
    }
}