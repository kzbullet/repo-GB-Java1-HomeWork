package ru.geekbrains;

public class Animal {
    private String name;
    private int runLimit;
    private int swimLimit;
    private int jumpLimit;

    public Animal(String name) {
        this.name = name;
    }

    public Animal(String name, int runLimit, int swimLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        this.jumpLimit = jumpLimit;
    }

    public void setRunLimit(int runLimit) {
        this.runLimit = runLimit;
    }

    public void setSwimLimit(int swimLimit) {
        this.swimLimit = swimLimit;
    }

    public void setJumpLimit(int jumpLimit) {
        this.jumpLimit = jumpLimit;
    }

    public void run(int distance) {
        if (distance < 0 || distance > runLimit) {
            System.out.println(name + " run of " + distance + " : false.");
        } else {
            System.out.println(name + " run of " + distance + " : true.");
        }
        System.out.println(name + " run limit is " + runLimit);
    }

    public void swim(int distance) {
        if (distance < 0 || distance > swimLimit) {
            System.out.println(name + " swim of " + distance + " : false.");
        } else {
            System.out.println(name + " swim of " + distance + " : true.");
        }
        System.out.println(name + " swim limit is " + swimLimit);
    }

    public void jump(int distance) {
        if (distance < 0 || distance > jumpLimit) {
            System.out.println(name + " jump over " + distance + " : false.");
        } else {
            System.out.println(name + " jump over " + distance + " : true.");
        }
        System.out.println(name + " jump limit is " + jumpLimit);
    }
}
