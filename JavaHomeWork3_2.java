package ru.geekbrains.lesson3;

import java.util.Random;
import java.util.Scanner;

public class JavaHomeWork3_2 {
    public static void main(String[] args) {
        // set up, initialization, etc.
        Scanner scn = new Scanner(System.in);
        Random rand = new Random();
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        // random word selection
        int randIndex = rand.nextInt(words.length);
        String compWord = words[randIndex];
        String userWord = "";
        // populate array to be printed in console with '#'
        char[] printCharArr = new char[15];
        for(int i = 0; i < printCharArr.length; i++) {
            printCharArr[i] = '#';
        }
        // game starts!
        System.out.println("Угадайте слово на латинице, загаданное компьютером.");
        while (!compWord.equals(userWord)) {
            System.out.println("Введите слово (латиницей).");
            userWord = scn.nextLine();
            if(compWord.equals(userWord)) {
                System.out.println("Вы угадали слово! Поздравляю!");
                break;
            } else {
                // find min iterations
                int minIter = (compWord.length() <= userWord.length())?compWord.length():userWord.length();
                // loop through to assign char that were guessed
                for(int i = 0; i < minIter; i++) {
                    if (compWord.charAt(i) == userWord.charAt(i)) {
                        printCharArr[i] = userWord.charAt(i);
                    }
                }
                System.out.println("Вы не угадали, но вот буквы, которые вы угадали:");
                // print out array of #'s with correct char's
                for(char i : printCharArr) {
                    System.out.print(i);
                }
                System.out.println();
            }
        }
    }
}
