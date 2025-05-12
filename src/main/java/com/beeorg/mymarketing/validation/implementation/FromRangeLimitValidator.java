package com.beeorg.mymarketing.validation.implementation;

import com.beeorg.mymarketing.service.RangeLimitService;
import com.beeorg.mymarketing.validation.annotation.FromRangeLimit;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FromRangeLimitValidator implements ConstraintValidator<FromRangeLimit, Integer> {

    private final RangeLimitService rangeLimitService;

    public FromRangeLimitValidator(RangeLimitService rangeLimitService) {
        this.rangeLimitService = rangeLimitService;
    }

    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {
        if (id == null) return true;
        try {
            return rangeLimitService.isFromValidity(id);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void initialize(FromRangeLimit constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
