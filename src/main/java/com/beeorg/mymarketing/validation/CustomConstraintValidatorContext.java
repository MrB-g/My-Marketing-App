package com.beeorg.mymarketing.validation;

import jakarta.validation.ConstraintValidatorContext;

public class CustomConstraintValidatorContext {

    public static void modify(String errorMessage, String propertyNode, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMessage).addPropertyNode(propertyNode).addConstraintViolation();
    }
}
