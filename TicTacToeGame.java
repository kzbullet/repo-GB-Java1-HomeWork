package ru.geekbrains.lesson3;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

    static final int FIELD_SIZE = 5;
    static final int WIN_CELL = 4;
    static final char HUM_CELL = 'x';
    static final char COMP_CELL = 'o';
    static final char EMPTY_CELL = '\u00B7';
    static char[][] field = new char[FIELD_SIZE][FIELD_SIZE];
    static Scanner scn = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        fillField();
        printField();

        while (!fieldIsFull()) {
            humMove();
            if (checkWin(HUM_CELL)) {
                System.out.println("You won! Congratulations!");
                break;
            }
            if (fieldIsFull()) System.out.println("This is a draw!");
            compMove();
            if (checkWin(COMP_CELL)) {
                System.out.println("Computer won! GAME OVER");
                break;
            }
        }
    }

    public static void fillField() {
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                field[i][j] = EMPTY_CELL;
            }
        }
    }

    public static void printField() {
        System.out.print("  ");
        for (int i = 0; i < field.length; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < field.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void humMove() {
        int x, y;
        do {
            System.out.println("Enter coordinates 'x' and 'y' from 1 to " + FIELD_SIZE);
            x = scn.nextInt() - 1;
            y = scn.nextInt() - 1;
        } while (!cellIsEmpty(x, y));
        field[x][y] = HUM_CELL;
        printField();
    }

    // AI for computer moves
    public static int riskInRowNum() {
        int r = -1;
        int count = 0;
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (!rowIsFull(i)) {
                    if (field[i][j] == HUM_CELL) {
                        count++;
                    }
                }
            }
            if (count == WIN_CELL - 1) {
                r = i;
                break;
            }
            count = 0;
        }
        return r;
    }

    public static int[] coordByRow() {
        int[] coord = new int[5];
        outerloop:
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (j + 2 < FIELD_SIZE) {
                    if (field[i][j] == HUM_CELL && field[i][j] == field[i][j + 1] && field[i][j + 2] == EMPTY_CELL) {
                        coord[0] = 1;
                        coord[1] = i;
                        coord[2] = j;
                        coord[3] = i;
                        coord[4] = j + 1;
                        break outerloop;
                    }
                }
            }
            for (int j = FIELD_SIZE - 1; j > -1; j--) {
                if (j - 2 > -1) {
                    if (field[i][j] == HUM_CELL && field[i][j] == field[i][j - 1] && field[i][j - 2] == EMPTY_CELL) {
                        coord[0] = 1;
                        coord[1] = i;
                        coord[2] = j - 1;
                        coord[3] = i;
                        coord[4] = j;
                        break outerloop;
                    }
                }
            }
        }
        return coord;
    }

    public static int riskInColNum() {
        int r = -1;
        int count = 0;
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (!colIsFull(i)) {
                    if (field[j][i] == HUM_CELL) {
                        count++;
                    }
                }
            }
            if (count == WIN_CELL - 1) {
                r = i;
                break;
            }
            count = 0;
        }
        return r;
    }

    public static int[] coordByCol() {
        int[] coord = new int[5];
        outerloop:
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (j + 2 < FIELD_SIZE) {
                    if (field[j][i] == HUM_CELL && field[j][i] == field[j + 1][i] && field[j + 2][i] == EMPTY_CELL) {
                        coord[0] = 1;
                        coord[1] = j;
                        coord[2] = i;
                        coord[3] = j + 1;
                        coord[4] = i;
                        break outerloop;
                    }
                }
            }
            for (int j = FIELD_SIZE - 1; j > -1; j--) {
                if (j - 2 > -1) {
                    if (field[j][i] == HUM_CELL && field[j][i] == field[j - 1][i] && field[j - 2][i] == EMPTY_CELL) {
                        coord[0] = 1;
                        coord[1] = j - 1;
                        coord[2] = i;
                        coord[3] = j;
                        coord[4] = i;
                        break outerloop;
                    }
                }
            }

        }
        return coord;
    }

    public static int[] coordByDiagOne() {
        int[] coord = new int[5];
        for (int i = 0; i < FIELD_SIZE; i++) {
            if (i + 2 < FIELD_SIZE) {
                if (field[i][i] == HUM_CELL && field[i][i] == field[i + 1][i + 1] && field[i + 2][i + 2] == EMPTY_CELL) {
                    coord[0] = 1;
                    coord[1] = i;
                    coord[2] = i;
                    coord[3] = i + 1;
                    coord[4] = i + 1;
                    break;
                }
            }
        }
        for (int i = FIELD_SIZE - 1; i > -1; i--) {
            if (i - 2 > -1) {
                if (field[i][i] == HUM_CELL && field[i][i] == field[i - 1][i - 1] && field[i - 2][i - 2] == EMPTY_CELL) {
                    coord[0] = 1;
                    coord[1] = i - 1;
                    coord[2] = i - 1;
                    coord[3] = i;
                    coord[4] = i;
                    break;
                }
            }
        }
        return coord;
    }

    public static int[] coordByDiagTwo() {
        int[] coord = new int[5];
        for (int i = 0; i < FIELD_SIZE; i++) {
            int j = FIELD_SIZE - 1 - i;
            if (i + 2 < FIELD_SIZE) {
                if (field[i][j] == HUM_CELL && field[i][j] == field[i + 1][j - 1] && field[i + 2][j - 2] == EMPTY_CELL) {
                    coord[0] = 1;
                    coord[1] = i + 1;
                    coord[2] = j - 1;
                    coord[3] = i;
                    coord[4] = j;
                    break;
                }
            }
        }
        for (int i = FIELD_SIZE - 1; i > -1; i--) {
            int j = FIELD_SIZE - 1 - i;
            if (j + 2 < FIELD_SIZE) {
                if (field[i][j] == HUM_CELL && field[i][j] == field[i - 1][j + 1] && field[i - 2][j + 2] == EMPTY_CELL) {
                    coord[0] = 1;
                    coord[1] = i;
                    coord[2] = j;
                    coord[3] = i - 1;
                    coord[4] = j + 1;
                    break;
                }
            }
        }
        return coord;
    }

    public static void compMove() {
        int x, y;
        do {
            x = rand.nextInt(FIELD_SIZE);
            y = rand.nextInt(FIELD_SIZE);
            if (coordByRow()[0] == 1) {
                if (cellIsEmpty(coordByRow()[1], (coordByRow()[2] - 1))) {
                    x = coordByRow()[1];
                    y = coordByRow()[2] - 1;
                } else if (cellIsEmpty(coordByRow()[3], (coordByRow()[4] + 1))) {
                    x = coordByRow()[3];
                    y = coordByRow()[4] + 1;
                }
            } else if (riskInRowNum() != -1) {
                x = riskInRowNum();
                y = rand.nextInt(FIELD_SIZE);
            } else if (coordByCol()[0] == 1) {
                if (cellIsEmpty((coordByCol()[1] - 1), coordByCol()[2])) {
                    x = coordByCol()[1] - 1;
                    y = coordByCol()[2];
                } else if (cellIsEmpty((coordByCol()[3] + 1), coordByCol()[4])) {
                    x = coordByCol()[3] + 1;
                    y = coordByCol()[4];
                }
            } else if (riskInColNum() != -1) {
                x = rand.nextInt(FIELD_SIZE);
                y = riskInColNum();
            } else if (coordByDiagOne()[0] == 1) {
                if (cellIsEmpty((coordByDiagOne()[1] - 1), (coordByDiagOne()[2] - 1))) {
                    x = coordByDiagOne()[1] - 1;
                    y = coordByDiagOne()[2] - 1;
                } else if (cellIsEmpty((coordByDiagOne()[3] + 1), (coordByDiagOne()[4] + 1))) {
                    x = coordByDiagOne()[3] + 1;
                    y = coordByDiagOne()[4] + 1;
                }
            } else if (coordByDiagTwo()[0] == 1) {
                if (cellIsEmpty((coordByDiagTwo()[1] + 1), (coordByDiagTwo()[2] - 1))) {
                    x = coordByDiagTwo()[1] + 1;
                    y = coordByDiagTwo()[2] - 1;
                } else if (cellIsEmpty((coordByDiagTwo()[3] - 1), (coordByDiagTwo()[4] + 1))) {
                    x = coordByDiagTwo()[3] - 1;
                    y = coordByDiagTwo()[4] + 1;
                }
            } else {
                x = rand.nextInt(FIELD_SIZE);
                y = rand.nextInt(FIELD_SIZE);
            }
        } while (!cellIsEmpty(x, y));
        field[x][y] = COMP_CELL;
        System.out.println("Computer made move at coordinates: [" + (x + 1) + ", " + (y + 1) + "].");
        printField();
    }

    // check cell availability
    public static boolean cellIsEmpty(int x, int y) {
        boolean result = false;
        if (x >= 0 && x <= FIELD_SIZE && y >= 0 && y <= FIELD_SIZE) {
            if (field[x][y] == EMPTY_CELL) {
                result = true;
            }
        }
        return result;
    }

    public static boolean rowIsFull(int r) {
        boolean result;
        int countEmptyCell = 0;
        for (int i = 0; i < FIELD_SIZE; i++) {
            if (field[r][i] == EMPTY_CELL) {
                countEmptyCell++;
            }
        }
        result = countEmptyCell == 0;
        return result;
    }

    public static boolean colIsFull(int c) {
        boolean result;
        int countEmptyCell = 0;
        for (int i = 0; i < FIELD_SIZE; i++) {
            if (field[i][c] == EMPTY_CELL) {
                countEmptyCell++;
            }
        }
        result = countEmptyCell == 0;
        return result;
    }

    public static boolean fieldIsFull() {
        boolean result;
        int countEmptyCell = 0;
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (field[i][j] == EMPTY_CELL) {
                    countEmptyCell++;
                }
            }
        }
        result = countEmptyCell == 0;
        return result;
    }

    // win condition section
    public static boolean winByRow(char c) {
        boolean result = false;
        int count = 0;
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (j + 1 < FIELD_SIZE) {
                    if (field[i][j] == c && field[i][j] == field[i][j + 1]) {
                        count++;
                    }
                }
            }
            if (count == WIN_CELL - 1) {
                result = true;
                break;
            }
            count = 0;
        }
        return result;
    }

    public static boolean winByCol(char c) {
        boolean result = false;
        int count = 0;
        int x, y;
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                x = j;
                y = i;
                if (x + 1 < FIELD_SIZE) {
                    if (field[x][y] == c && field[x][y] == field[x + 1][y]) {
                        count++;
                    }
                }
            }
            if (count == WIN_CELL - 1) {
                result = true;
                break;
            }
            count = 0;
        }
        return result;
    }

    public static boolean winByDiagOne(char c) {
        boolean result = false;
        int count = 0;
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (i + 1 < FIELD_SIZE) {
                    if (i == j && field[i][j] == c && field[i][j] == field[i + 1][j + 1]) {
                        count++;
                    }
                }
            }
            if (count == WIN_CELL - 1) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean winByDiagTwo(char c) {
        boolean result = false;
        int count = 0;
        for (int i = 0; i < FIELD_SIZE; i++) {
            if (FIELD_SIZE - 2 - i >= 0) {
                if (field[i][FIELD_SIZE - 1 - i] == c && field[i][FIELD_SIZE - 1 - i] == field[i + 1][FIELD_SIZE - 2 - i]) {
                    count++;
                }
            }
            if (count == WIN_CELL - 1) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean checkWin(char c) {
        boolean result = false;
        if (winByRow(c) || winByCol(c) || winByDiagOne(c) || winByDiagTwo(c)) {
            result = true;
        }
        return result;
    }
}