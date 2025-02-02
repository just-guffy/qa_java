package com.example;

import java.util.List;

public class Lion {

    // Поле feline, которое будет инициализироваться извне через конструктор
    private final Feline feline;

    // Поле hasMane, определяющее наличие гривы у льва
    private final boolean hasMane;

    // Конструктор, принимающий два параметра: объект Feline и строку с указанием пола
    public Lion(Feline feline, String sex) throws Exception {
        // Сохранение переданного объекта feline в приватное поле
        this.feline = feline;

        // Определение наличия гривы в зависимости от переданного пола
        if ("Самец".equals(sex)) {
            // Если пол "Самец", устанавливаем hasMane в true
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            // Если пол "Самка", устанавливаем hasMane в false
            hasMane = false;
        } else {
            // Если передан недопустимый пол, выбрасывается исключение
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    // Метод для получения количества котят, делегирует вызов классу Feline
    public int getKittens() {
        // Делегирование вызова метода getKittens() объекту feline
        return feline.getKittens();
    }

    // Геттер для определения наличия гривы у льва
    public boolean doesHaveMane() {
        // Возвращает значение поля hasMane
        return hasMane;
    }

    // Метод для получения списка пищи для льва, делегирует вызов классу Feline
    public List<String> getFood() throws Exception {
        // Делегирование вызова метода getFood() объекту feline
        return feline.getFood("Хищник");
    }
}