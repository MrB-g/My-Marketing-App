package com.beeorg.mymarketing.validation.implementation;

import com.beeorg.mymarketing.service.RangeLimitService;
import com.beeorg.mymarketing.validation.annotation.ToRangeLimit;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ToRangeLimitValidator implements ConstraintValidator<ToRangeLimit, Integer> {

    private final RangeLimitService rangeLimitService;

    public ToRangeLimitValidator(RangeLimitService rangeLimitService) {
        this.rangeLimitService = rangeLimitService;
    }

    @Override
    public void initialize(ToRangeLimit constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {
        if (id == null) return true;
        try {
            return !rangeLimitService.isFromValidity(id);
        } catch (Exception e) {
            return false;
        }
    }
}
