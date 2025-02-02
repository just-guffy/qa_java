package com.example;

import java.util.List;

// Класс Feline
public class Feline extends Animal implements Predator {
    private Animal animal;

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public List<String> eatMeat() throws Exception {
        if (this.animal == null) {
            return super.getFood("Хищник");
        } else {
            return this.animal.getFood("Хищник");
        }
    }

    @Override
    public String getFamily() {
        return "Кошачьи";
    }

    public int getKittens() {
        return getKittens(1);
    }

    public int getKittens(int kittensCount) {
        return kittensCount;
    }
}