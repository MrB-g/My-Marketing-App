package com.beeorg.mymarketing.validation.implementation;

import com.beeorg.mymarketing.validation.annotation.PasswordMatches;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {}

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext context) {
        if (o == null) return true;
        try {
            String password = (String) o.getClass().getMethod("getPassword").invoke(o);
            if (password == null) {
                customConstraintValidatorContext("Password can't be null", "password", context);
                return false;
            }
            String confirmPassword = (String) o.getClass().getMethod("getConfirmPassword").invoke(o);
            if (confirmPassword == null) {
                customConstraintValidatorContext("Confirm Password can't be null", "confirmPassword", context);
                return false;
            }
            return password.equals(confirmPassword);
        } catch (Exception e) {
            return false;
        }
    }

    private void customConstraintValidatorContext(String errorMessage, String propertyNode, ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(errorMessage).addPropertyNode(propertyNode).addConstraintViolation();
    }
}
