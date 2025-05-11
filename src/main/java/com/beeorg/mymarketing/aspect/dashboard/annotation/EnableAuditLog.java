package com.beeorg.mymarketing.aspect.dashboard.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface EnableAuditLog {
}
