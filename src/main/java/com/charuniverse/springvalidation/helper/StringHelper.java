package com.charuniverse.springvalidation.helper;

import org.springframework.stereotype.Component;

@Component
public class StringHelper {

    public Boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
}
