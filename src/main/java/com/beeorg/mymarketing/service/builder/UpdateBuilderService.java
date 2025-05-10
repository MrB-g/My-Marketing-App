package com.beeorg.mymarketing.service.builder;

public interface UpdateBuilderService<R, T> {

    R update(T t, R r);
}
