package ru.geekbrains;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("Plate has: " + food + " food.");
    }

    public void decreaseFood(int n) {
        if ((food - n) >= 0) {
            food -= n;
        }
    }

    public void addFood(int n) {
        if(n > 0) {
            food += n;
            System.out.println("Plate has: " + food + " food.");
        }
    }

    public int getFood() {
        return food;
    }
}
