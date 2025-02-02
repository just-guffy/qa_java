package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    private Lion lion;

    @Before
    public void setup() throws Exception {
        // Создаем объект Lion вручную с нужным значением пола
        lion = new Lion(feline, "Самец");
    }

    @Test(expected = Exception.class)
    public void testConstructorInvalidSex() throws Exception {
        // Пробуем создать объект Lion с неверным значением пола
        new Lion(feline, "Неверный пол");
    }

    @Test
    public void testConstructorMale() throws Exception {
        // Создаем объект Lion с полом "Самец"
        Lion maleLion = new Lion(feline, "Самец");
        // Проверяем, что у самца есть грива
        assertTrue(maleLion.doesHaveMane());
    }

    @Test
    public void testConstructorFemale() throws Exception {
        // Создаем объект Lion с полом "Самка"
        Lion femaleLion = new Lion(feline, "Самка");
        // Проверяем, что у самки нет гривы
        assertFalse(femaleLion.doesHaveMane());
    }

    @Test
    public void testGetKittens() {
        // Настраиваем поведение мока feline, чтобы при вызове getKittens() возвращалось значение 3
        when(feline.getKittens()).thenReturn(3);

        // Вызываем метод getKittens() и сохраняем результат в переменную
        int kittens = lion.getKittens();

        // Сравниваем ожидаемый и полученный результаты
        assertEquals(3, kittens);
    }

    @Test
    public void testGetFood() throws Exception {
        // Настраиваем поведение мока feline, чтобы при вызове getFood() возвращался фиксированный список
        when(feline.getFood(anyString())).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));

        // Вызываем метод getFood() и сохраняем результат в переменную
        List<String> food = lion.getFood();

        // Сравниваем ожидаемый и полученный результаты
        assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), food);
    }
}