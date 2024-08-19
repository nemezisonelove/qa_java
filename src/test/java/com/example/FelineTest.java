package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FelineTest {

    @Test
    public void getKittensNoParamsReturnOne() {

        Feline feline = new Feline();

        int expectedResult = 1;

        int actualResult = feline.getKittens();

        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void getFamilyTest() {

        Feline feline = new Feline();

        String expectedResult = "Кошачьи";

        String actualResult = feline.getFamily();

        assertEquals(expectedResult, actualResult);

    }

}