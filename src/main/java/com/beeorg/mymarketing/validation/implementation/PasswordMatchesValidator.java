package com.beeorg.mymarketing.validation.implementation;

import com.beeorg.mymarketing.validation.CustomConstraintValidatorContext;
import com.beeorg.mymarketing.validation.annotation.PasswordMatches;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    private String passwordField;
    private String confirmPasswordField;

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
        this.passwordField = constraintAnnotation.passwordField();
        this.confirmPasswordField = constraintAnnotation.confirmPasswordField();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext context) {
        if (o == null) return true;
        try {
            String password = getFieldValue(o, passwordField);
            if (password == null) {
                CustomConstraintValidatorContext.modify("Password can't be null", "password", context);
                return false;
            }
            String confirmPassword = getFieldValue(o, confirmPasswordField);
            if (confirmPassword == null) {
                CustomConstraintValidatorContext.modify("Confirm Password can't be null", "confirmPassword", context);
                return false;
            }
            return password.equals(confirmPassword);
        } catch (Exception e) {
            return false;
        }
    }

    private String getFieldValue(Object o, String fieldName) {
        try {
            Field field = o.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(o).toString();
        } catch (Exception e) {
            return null;
        }
    }
}