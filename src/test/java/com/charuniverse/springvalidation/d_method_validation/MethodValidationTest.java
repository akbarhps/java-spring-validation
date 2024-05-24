package com.charuniverse.springvalidation.d_method_validation;

import com.charuniverse.springvalidation.helper.SayHello;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MethodValidationTest {

    @Autowired
    private SayHello sayHello;

    @Test
    void testSuccess() {
        String message = sayHello.sayHello("Andi");
        Assertions.assertEquals("Hello Andi", message);
    }

    @Test
    void testFailed() {
        Assertions.assertThrows(Exception.class, () -> sayHello.sayHello(null));
    }
}
