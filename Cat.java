package ru.geekbrains;

public class Cat extends Animal {
    public Cat(String name) {
        super(name, 200, -1, 2);
    }

    @Override
    public void swim(int distance) {
        System.out.println("Cat's cannot swim at all!");
    }
}
