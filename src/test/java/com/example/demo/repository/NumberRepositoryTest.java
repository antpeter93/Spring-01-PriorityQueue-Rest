package com.example.demo.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
class NumberRepositoryTest {
    @Autowired
    private NumberRepository underTest;

   // @Test
    void testHeapSize() {
        //GIVEN

        //WHEN

        //THEN
        Assertions.assertEquals(100, underTest.getHeapSize());
        Assertions.assertEquals(100, underTest.getNumbersAsMaxHeap().size());
    }

}