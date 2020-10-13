package ru.geekbrains;

public class Main {

    public static void main(String[] args) {
        Dog dogBella = new Dog("Bella");
        dogBella.run(600);
        dogBella.swim(15);
        dogBella.jump(1);

        Dog dogCharlie = new Dog("Charlie");
        dogCharlie.setRunLimit(700);
        dogCharlie.run(600);
        dogCharlie.swim(10);
        dogCharlie.jump(3);

        Cat catKitty = new Cat("Kitty");
        catKitty.run(200);
        catKitty.swim(0);
        catKitty.jump(1);
    }
}
