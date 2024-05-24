package com.charuniverse.springvalidation.validation;

import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PalindromeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Palindrome {

    String message() default "{Palindrome.message}";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};

}
