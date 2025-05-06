package com.beeorg.mymarketing.validation.implementation;

import com.beeorg.mymarketing.validation.annotation.NotDuplicate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotDuplicateValidator implements ConstraintValidator<NotDuplicate, String> {

    private String column;
    private String table;

    @Override
    public void initialize(NotDuplicate constraintAnnotation) {
        this.column = constraintAnnotation.column();
        this.table = constraintAnnotation.table();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }

    private void customConstraintValidatorContext(String errorMessage, String propertyNode, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMessage).addPropertyNode(propertyNode).addConstraintViolation();
    }
}
