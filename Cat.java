package ru.geekbrains;

public class Cat {
    private String name;
    private int appetite;
    private boolean fullness;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = false;
    }

    public void eat(Plate plate) {
        if (plate.getFood() >= appetite) {
            plate.decreaseFood(appetite);
            fullness = true;
            System.out.println("Cat '" + name + "' ate its food.");
        } else {
            System.out.println("Not enough food. Cat '" + name + "' is still hungry.");
        }
    }

    public boolean isFullness() {
        return fullness;
    }
}
