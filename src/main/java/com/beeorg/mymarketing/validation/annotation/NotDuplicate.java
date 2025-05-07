package com.beeorg.mymarketing.validation.annotation;

import com.beeorg.mymarketing.validation.implementation.NotDuplicateValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotDuplicateValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotDuplicate {

    String message() default "Provided value already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String column();

    String table();
}