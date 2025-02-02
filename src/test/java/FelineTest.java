package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    private Animal animal;

    // Тестовый метод для проверки метода eatMeat()
    @Test
    public void testEatMeat() throws Exception {
        // Настраиваем поведение мока animal, чтобы при вызове getFood() возвращался фиксированный список
        when(animal.getFood(anyString())).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));

        // Создаем экземпляр класса Feline
        Feline feline = new Feline();

        // Убедимся, что feline использует mock объекта animal
        feline.setAnimal(animal); // Добавляем этот метод в класс Feline для возможности установки мока

        // Вызываем метод eatMeat() и сохраняем результат в переменную
        List<String> food = feline.eatMeat();

        // Сравниваем ожидаемый и полученный результаты
        assertEquals(Arrays.asList("Животные", "Птицы", "Рыба"), food);
    }

    // Тестовый метод для проверки метода getFamily()
    @Test
    public void testGetFamily() {
        // Создаем экземпляр класса Feline
        Feline feline = new Feline();
        // Вызываем метод getFamily() и сохраняем результат в переменную
        String family = feline.getFamily();

        // Сравниваем ожидаемый и полученный результаты
        assertEquals("Кошачьи", family);
    }

    // Тестовый метод для проверки метода getKittens() без параметров
    @Test
    public void testGetKittensDefault() {
        // Создаем экземпляр класса Feline
        Feline feline = new Feline();
        // Вызываем метод getKittens() и сохраняем результат в переменную
        int kittens = feline.getKittens();

        // Сравниваем ожидаемый и полученный результаты
        assertEquals(1, kittens);
    }

    // Тестовый метод для проверки метода getKittens() с параметрами
    @Test
    public void testGetKittensCustom() {
        // Создаем экземпляр класса Feline
        Feline feline = new Feline();
        // Вызываем метод getKittens() с параметром и сохраняем результат в переменную
        int kittens = feline.getKittens(3);

        // Сравниваем ожидаемый и полученный результаты
        assertEquals(3, kittens);
    }
}