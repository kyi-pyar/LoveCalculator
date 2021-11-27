package com.springmvc.calculator.Validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface AgeValidator {
	String message() default "Age between 10 to 40";
	int upper() default 40;
	int lower() default 10;
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
