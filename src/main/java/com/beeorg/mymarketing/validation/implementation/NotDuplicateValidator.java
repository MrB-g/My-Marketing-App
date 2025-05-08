package com.beeorg.mymarketing.validation.implementation;

import com.beeorg.mymarketing.validation.CustomConstraintValidatorContext;
import com.beeorg.mymarketing.validation.annotation.NotDuplicate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotDuplicateValidator implements ConstraintValidator<NotDuplicate, Object> {

    private final EntityManager entityManager;
    private String column;
    private String table;
    private boolean reverse;

    public NotDuplicateValidator(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void initialize(NotDuplicate constraintAnnotation) {
        this.column = constraintAnnotation.column();
        this.table = constraintAnnotation.table();
        this.reverse = constraintAnnotation.reverse();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) return true;
        try {
            if (this.column == null) {
                CustomConstraintValidatorContext.modify("Column can't be null", "column", context);
                return false;
            }
            if (this.table == null) {
                CustomConstraintValidatorContext.modify("Table can't be null", "table", context);
                return false;
            }
            String sql = String.format("SELECT count(*) FROM %s WHERE %s = :value", this.table, this.column);
            Query query = entityManager.createNativeQuery(sql).setParameter("value", value);
            long count = (Long) query.getSingleResult();
            if (this.reverse) {
                if (count == 0) {
                    CustomConstraintValidatorContext.modify("Provided value doesn't exist", "", context);
                    return false;
                }
                return true;
            } else {
                return count == 0;
            }
        } catch (Exception e) {
            return false;
        }
    }
}