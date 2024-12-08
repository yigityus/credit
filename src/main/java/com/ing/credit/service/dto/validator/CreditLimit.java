package com.ing.credit.service.dto.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CreditLimitValidator.class)
public @interface CreditLimit {
    String message() default "Insufficient credit limit balance";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
