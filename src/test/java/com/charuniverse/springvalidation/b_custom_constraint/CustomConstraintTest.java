package com.charuniverse.springvalidation.b_custom_constraint;

import com.charuniverse.springvalidation.data.Foo;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
public class CustomConstraintTest {

    @Autowired
    private Validator validator;

    @Test
    void testValidPalindrome() {
        Set<ConstraintViolation<Foo>> violations = validator.validate(new Foo("not palindrome"));
        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertEquals(1, violations.size());
    }

    @Test
    void testInvalidPalindrome() {
        Set<ConstraintViolation<Foo>> violations = validator.validate(new Foo("kodok"));
        Assertions.assertTrue(violations.isEmpty());
    }
}
