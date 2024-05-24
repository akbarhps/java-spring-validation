package com.charuniverse.springvalidation.c_message_source;

import com.charuniverse.springvalidation.data.Foo;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    private Validator validator;

    @Test
    void testInvalidMessage() {
        Set<ConstraintViolation<Foo>> violations = validator.validate(new Foo("bukan plaind"));
        Assertions.assertFalse(violations.isEmpty());

        String message = violations.iterator().next().getMessage();
        Assertions.assertEquals("Data bukan palindrome", message);
    }
}
