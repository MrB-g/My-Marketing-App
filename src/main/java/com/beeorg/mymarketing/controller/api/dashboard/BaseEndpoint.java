package com.beeorg.mymarketing.controller.api.dashboard;

import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping("/api/dashboard/")
public @interface BaseEndpoint {
}