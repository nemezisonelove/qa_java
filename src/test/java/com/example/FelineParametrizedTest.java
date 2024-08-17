package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class FelineParametrizedTest {
    private final int foodId;
    private final String foodType;

    private final int kittensAmount;

    public FelineParametrizedTest(int foodId, String foodType, int kittensAmount) {
        this.foodId = foodId;
        this.foodType = foodType;
        this.kittensAmount = kittensAmount;
    }

    @Parameterized.Parameters
    public static Object[][] getFelineData() {
        return new Object[][] {
                {0,"Животные", -1},
                {1,"Птицы", 1},
                {2,"Рыба", 0},
        };
    }

    @Test
    public void eatMeatTest() throws Exception {

        Feline feline = new Feline();

        String actualFoodType = feline.eatMeat().get(foodId);

        assertEquals(foodType, actualFoodType);
    }

    @Test
    public void getKittensReturnSameParam() {
        Feline feline = new Feline();

        int actualResult = feline.getKittens(kittensAmount);

        assertEquals(kittensAmount, actualResult);
    }
}