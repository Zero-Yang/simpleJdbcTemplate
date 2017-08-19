package com.java.jdbcTemplate.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.java.jdbcTemplate.model.GenerationType;

@Target({METHOD, FIELD})
@Retention(RUNTIME)

public @interface GeneratedValue {

	GenerationType strategy() default GenerationType.AUTO;

    String generator() default "";
}
