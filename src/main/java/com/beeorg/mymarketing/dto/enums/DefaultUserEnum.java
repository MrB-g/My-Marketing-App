package com.beeorg.mymarketing.dto.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DefaultUserEnum {

    SYSTEM("SYSTEM");

    private final String name;
}