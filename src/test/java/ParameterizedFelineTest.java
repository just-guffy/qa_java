package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class ParameterizedFelineTest {

    @Mock
    private Animal animal;

    private int input;
    private int expectedOutput;

    public ParameterizedFelineTest(int input, int expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Before
    public void setUp() {
        // Инициализируем моки вручную
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0},
                {1, 1},
                {2, 2},
                {3, 3},
                {-1, -1},
                {10, 10}
        });
    }

    @Test
    public void testGetKittensParametrized() {
        try {
            // Настраиваем поведение мока animal, чтобы при вызове getFood() возвращался фиксированный список.
            when(animal.getFood(anyString())).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));

            // Создаем экземпляр класса Feline.
            Feline feline = new Feline();

            // Вызываем метод getKittens() с параметром и сохраняем результат в переменную.
            int kittens = feline.getKittens(input);

            // Сравниваем ожидаемый и полученный результаты.
            assertEquals(expectedOutput, kittens);
        } catch (Exception e) {
            // Обрабатываем возможное исключение.
            e.printStackTrace(); // Логируем исключение для диагностики.
            fail("Исключение не должно было возникнуть."); // Завершаем тест неудачей.
        }
    }
}