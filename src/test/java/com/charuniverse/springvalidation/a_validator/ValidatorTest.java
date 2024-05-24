package com.charuniverse.springvalidation.a_validator;

import com.charuniverse.springvalidation.data.Person;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
public class ValidatorTest {

    @Autowired
    private Validator validator;

    @Test
    void testValidatorWithInvalidInput() {
        Person person = new Person();
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        Assertions.assertFalse(violations.isEmpty());
        Assertions.assertEquals(2, violations.size());
    }

    @Test
    void testValidatorWithValidInput() {
        Person person2 = new Person("akbar", "gemink");
        Set<ConstraintViolation<Person>> violations2 = validator.validate(person2);
        Assertions.assertTrue(violations2.isEmpty());
    }
}
