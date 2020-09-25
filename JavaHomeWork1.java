package ru.geekbrains.lesson1;

public class JavaHomeWork1 {
    //task1
    public static void main(String[] args) {
    //task2
        byte by = 121;
        short sh = -29999;
        int i = 87878787;
        long lo = 1234567890;
        float fl = 6.123456f;
        double dbl = 14.12345678901234;
        char chr = 'B';
        boolean bln = true;

        System.out.println(calcFloat(3.47188f, 4.28941f, 19.2893f, 2.38283f));
        System.out.println(checkNumRange(4,15));
        checkPositiveNum(0);
        System.out.println(checkNegativeNum(-99));
        sayHi("Андрей");
        checkLeapYear(2020);
    }
    //task3
    static float calcFloat(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }
    //task4
    static boolean checkNumRange(int num1, int num2) {
        int sumNums = num1 + num2;
        if (sumNums >= 10 && sumNums <= 20) {
            return true;
        } else {
            return false;
        }
    }
    //task5
    static void checkPositiveNum(int num) {
        String result = (num >= 0) ? "positive" : "negative";
        System.out.println("Number " + num + " is " + result);
    }
    //task6
    static boolean checkNegativeNum(int num) {
        boolean result = (num < 0) ? true : false;
        return result;
    }
    //task7
    static void sayHi(String name) {
        System.out.println("\"Привет, " + name + ",\nНу где ты был,\nНу обмними меня скорей!\"");
    }
    //task8*
    static void checkLeapYear(int year) {
        boolean leapYear;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    leapYear = true;
                } else {
                    leapYear = false;
                }
            } else {
                leapYear = true;
            }
        } else {
            leapYear = false;
        }
        String leapYearText = leapYear ? "високосный" : "не високосный";
        System.out.println(year + " год " + leapYearText);
    }
}
