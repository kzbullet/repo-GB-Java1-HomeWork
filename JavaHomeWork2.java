package ru.geekbrains.lesson2;

public class JavaHomeWork2 {

    public static void main(String[] args) {
        // task #1
        int[] arr1 = {1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0};
        for (int i : arr1) {
            if (i == 0) {
                i = 1;
            } else i = 0;
            System.out.print(i + " ");
        }
        twoLine();
        // task #2
        int[] arr2 = new int[8];
        int content = 0;
        for (int i = 0; i < arr2.length; i ++) {
            arr2[i] = content;
            content += 3;
            System.out.print(arr2[i] + " ");
        }
        twoLine();
        // task #3
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                int result = arr3[i] * 2;
                System.out.print(result + " ");
            }
        }
        twoLine();
        // task #4
        int sqr = 8;
        int[][] arr4 = new int[sqr][sqr];
        for (int i = 0; i < sqr; i++) {
            for (int j = 0; j < sqr; j++) {
                if (i == j) {
                    arr4[i][j] = 1;
                } else if (i + j == sqr - 1) {
                    arr4[i][j] = 1;
                } else {
                    arr4[i][j] = 0;
                }
                System.out.print(arr4[i][j] + " ");
            }
            System.out.println();;
        }
        oneLine();
        // task #5**
        int minN = arr3[0];
        int maxN = arr3[0];
        for (int i = 0; i < arr3.length - 1; i++) {
            if (arr3[i + 1] < minN) minN = arr3[i + 1];
            if (arr3[i + 1] > maxN) maxN = arr3[i + 1];
        }
        System.out.println("Minimum number is " + minN);
        System.out.println("Maximum number is " + maxN);
        oneLine();
        // task #6**
        int[] arrTest6_1 = {2, 2, 2, 1, 2, 2, 10, 3};
        int[] arrTest6_2 = {6, 1, 4, 5, 2, 3, 7, 2, 1, 6, 23};
        System.out.println(checkBalance(arrTest6_1));
        System.out.println(checkBalance(arrTest6_2));
        oneLine();
        // task #7**
        int[] arrTest7_1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        arrayElementsMove(arrTest7_1, 2);
        int[] arrTest7_2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        arrayElementsMove(arrTest7_2, -1);
    }
    // task #6**
    static boolean checkBalance(int[] arr) {
        boolean result = false;
        // calculate total sum of the array elements
        int sumTotal = 0;
        for (int i = 0; i < arr.length; i++) {
            sumTotal += arr[i];
        }
        // check left sum of array elements with the right side (total - left)
        int sumLeft = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sumLeft += arr[i];
            if (sumLeft == sumTotal - sumLeft) {
                result = true;
            }
        }
        return result;
    }
    // task #7****
    static void arrayElementsMove (int[] arr, int n) {
        if (n >= 0) {
            for (int j = 0; j < n; j++) {
                int nextNum = arr[arr.length - 1];
                for (int i = 0; i < arr.length; i++) {
                    int temp = arr[i];
                    arr[i] = nextNum;
                    nextNum = temp;
                }
            }
        } else {
            for (int j = 0; j < n * -1; j++) {
                int nextNum = arr[0];
                for (int i = arr.length - 1; i >= 0; i--) {
                    int temp = arr[i];
                    arr[i] = nextNum;
                    nextNum = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    static void oneLine() {
        System.out.println();
    }
    static void twoLine() {
        System.out.println("\n");
    }
}
