package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensReturnCorrectValue() throws Exception {
        // Настроим поведение мок-объекта для использования в тесте
        Mockito.when(feline.getKittens()).thenReturn(1);

        // Используем конструктор Lion с инъекцией зависимости
        Lion lion = new Lion("Самец", feline);

        // Получаем количество детенышей
        int actualAmountOfKittens = lion.getKittens();

        // Проверяем, что количество детенышей соответствует ожидаемому
        assertEquals(1, actualAmountOfKittens);
    }

    @Test
    public void doesHaveManeShouldReturnTrueForMaleLion() throws Exception {
        Lion lion = new Lion("Самец", feline);

        boolean actualResult = lion.doesHaveMane();

        assertTrue(actualResult);
    }

    @Test
    public void doesHaveManeShouldReturnFalseForFemaleLion() throws Exception {
        Lion lion = new Lion("Самка", feline);

        boolean actualResult = lion.doesHaveMane();

        assertFalse(actualResult);
    }

    @Test(expected = Exception.class)
    public void lionConstructorShouldThrowExceptionForInvalidGender() throws Exception {
        new Lion("Тест", feline);
    }

    @Test
    public void getFoodTest() throws Exception {
        // Настроим поведение мок-объекта для использования в тесте
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedList);

        // Используем конструктор Lion с инъекцией зависимости
        Lion lion = new Lion("Самка", feline);

        // Получаем еду
        List<String> actualList = lion.getFood();

        // Проверяем, что полученный список соответствует ожидаемому
        assertEquals(expectedList, actualList);
    }
}