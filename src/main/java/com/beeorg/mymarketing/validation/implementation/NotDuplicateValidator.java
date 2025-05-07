package com.beeorg.mymarketing.validation.implementation;

import com.beeorg.mymarketing.validation.CustomConstraintValidatorContext;
import com.beeorg.mymarketing.validation.annotation.NotDuplicate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotDuplicateValidator implements ConstraintValidator<NotDuplicate, String> {

    private final EntityManager entityManager;
    private String column;
    private String table;

    public NotDuplicateValidator(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void initialize(NotDuplicate constraintAnnotation) {
        this.column = constraintAnnotation.column();
        this.table = constraintAnnotation.table();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
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
            return count == 0;
        } catch (Exception e) {
            return false;
        }
    }
}
