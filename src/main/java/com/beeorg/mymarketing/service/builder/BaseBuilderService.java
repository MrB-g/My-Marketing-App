package com.beeorg.mymarketing.service.builder;

public interface BaseBuilderService<R, T> {

    R build(T t);

    T reverse(R r);
}
