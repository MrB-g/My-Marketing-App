package com.beeorg.mymarketing.validation.annotation;

import com.beeorg.mymarketing.validation.implementation.ExistsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistsValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Exists {

    String message() default "Provided value doesn't exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String column() default "id";

    String table();
}
