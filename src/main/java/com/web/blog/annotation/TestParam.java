package com.web.blog.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // --- 1
@Retention(RetentionPolicy.RUNTIME) // --- 2
public @interface TestParam {
    String [] colName();
}