package com.beeorg.mymarketing.service.implementation;

import com.beeorg.mymarketing.dto.RangeLimitDto;
import com.beeorg.mymarketing.entity.RangeLimit;

public class RangeLimitEntityBuilderService implements com.beeorg.mymarketing.service.builder.RangeLimitEntityBuilderService {

    @Override
    public RangeLimit build(RangeLimitDto rangeLimit) {
        return RangeLimit.builder()
                .id(rangeLimit.getId())
                .typeName(rangeLimit.getTypeName())
                .typeSymbol(rangeLimit.getTypeSymbol())
                .validity(rangeLimit.getValidity())
                .build();
    }

    @Override
    public RangeLimitDto reverse(RangeLimit rangeLimitDto) {
        return RangeLimitDto.builder()
                .id(rangeLimitDto.getId())
                .typeName(rangeLimitDto.getTypeName())
                .typeSymbol(rangeLimitDto.getTypeSymbol())
                .validity(rangeLimitDto.getValidity())
                .build();
    }
}
