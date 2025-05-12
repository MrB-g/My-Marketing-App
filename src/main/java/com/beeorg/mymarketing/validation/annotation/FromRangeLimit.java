package com.beeorg.mymarketing.validation.annotation;

import com.beeorg.mymarketing.validation.implementation.FromRangeLimitValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FromRangeLimitValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FromRangeLimit {

    String message() default "Provided value is 'TO' range limit";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
