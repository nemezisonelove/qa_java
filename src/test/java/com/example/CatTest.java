package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSoundTest() {
        Cat cat = new Cat(feline);

        String expectedResult = "Мяу";

        String actualResult =  cat.getSound();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getFoodTest() throws Exception {

        Cat cat = new Cat(feline);

        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");

        List<String> actualList = cat.getFood();

        assertEquals(expectedList, actualList);

    }
}