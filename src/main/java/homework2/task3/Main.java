package homework2.task3;

import java.util.Random;
import java.util.Scanner;

/* *
 * Крестики-нолики поле 5х5 с проверкой на победу из 4-х одинаковых фишек (из task2) с
 * искусственным интеллектом, который проверяет наличие трёх одинаковых фишек у человека и
 * блокирует победный ход человека
 */

public class Main {
    // Задаём константы
    private static final char DOT_HUMAN = 'X'; // фишка игрока
    private static final char DOT_AI = '0'; // фишка компьютера
    private static final char DOT_EMPTY = '*'; // признак пустой ячейки
    private static final int WIN_COUNT = 4;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static char[][] field; // игровое поле - двумерный массив
    private static int fieldSizeX; // значение размерности игрового поля
    private static int fieldSizeY; // значение размерности игрового поля

    public static void main(String[] args) {
        do {
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (checkGameState(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (checkGameState(DOT_AI, "Победил компьютер!"))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
        } while (scanner.next().equalsIgnoreCase("Y"));
    }

    /**
     * Инициализация игрового поля
     */
    static void initialize() {
        fieldSizeY = 5;
        fieldSizeX = 5;

        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    /**
     * Печать текущего состояния игрового поля
     */

    private static void printField() {
        // рисуем хеддер поля
        System.out.print("+");
        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print("-" + (i + 1));
        }
        System.out.println("-");

        // рисуем боди поля, сначала идём по внешмему измерению, затем по внутреннему измерению
        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print(y + 1 + "|");
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }
        // рисуем футтер поля
        for (int i = 0; i < fieldSizeX * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Ход игрока (человека)
     */
    static void humanTurn() {
        int x;
        int y;

        do {
            // метод scanner.hasNextInt - проверяет буфер и возвращает true, если там число
            System.out.print("Введите координаты хода X и Y (от 1 до 5)\nчерез пробел: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));

        field[y][x] = DOT_HUMAN;
    }

    /**
     * Ход игрока (компьютера)
     */
    static void aiTurn() {
        if (!aiCheckHumanWin(WIN_COUNT)) {
            int x;
            int y;

            do {
                x = random.nextInt(fieldSizeX);
                y = random.nextInt(fieldSizeY);
            }
            while (!isCellEmpty(x, y));
            field[y][x] = DOT_AI;
        }
    }

    /**
     * Проверка, является ли ячейка игрового поля пустой
     *
     * @param x координата
     * @param y координата
     * @return результат проверки ячейки на пустоту
     */
    static boolean isCellEmpty(int x, int y) {
        return field[y][x] == DOT_EMPTY;
    }

    /**
     * Проверка доступности ячейки игрового поля
     *
     * @param x координата
     * @param y координата
     * @return результат проверки доступности ячейки
     */
    static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Метод проверки состояния игры
     *
     * @param dot фишка игрока
     * @param s   победный слоган
     * @return результат проверки состояния игры
     */
    static boolean checkGameState(char dot, String s) {
        if (checkWin(dot, WIN_COUNT)) {
            System.out.println(s);
            return true; // Игра окончена победой одного из игрока
        }
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        return false; // Игра продолжается
    }

    /**
     * Проверка на ничью
     *
     * @return результат проверки состояния игры
     */
    static boolean checkDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(x, y))
                    return false;
            }
        }
        return true;
    }


    /**
     * Проверка победы игрока
     *
     * @param dot фишка игрока
     * @return признак победы
     */
//    static boolean checkWin(char dot, int winCount) {
//        for (int y = 0; y < fieldSizeY; y++) {
//            for (int x = 0; x < fieldSizeX; x++) {
//                if (checkHo(x, y, dot, winCount) ||
//                        checkVe(x, y, dot, winCount) ||
//                        checkDiUp(x, y, dot, winCount) ||
//                        checkDiDo(x, y, dot, winCount)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
    static boolean checkWin(char dot, int winCount) {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (checkHo(x, y, dot, winCount)) return true;
                if (checkVe(x, y, dot, winCount)) return true;
                if (checkDiUp(x, y, dot, winCount)) return true;
                if (checkDiDo(x, y, dot, winCount)) return true;
            }
        }
        return false;
    }

    static boolean checkDiUp(int x, int y, char dot, int winCount) {
        if (isCellValid(x + winCount - 1, y - winCount + 1)) {
            if (field[y][x] == dot && field[y - 1][x + 1] == dot) {
                if (field[y - 2][x + 2] == dot) {
                    return field[y - 3][x + 3] == dot;
                }
            }
        }
        return false;
    }

    static boolean checkDiDo(int x, int y, char dot, int winCount) {
        if (isCellValid(x + winCount - 1, y + winCount - 1)) {
            if (field[y][x] == dot && field[y + 1][x + 1] == dot) {
                if (field[y + 2][x + 2] == dot) {
                    return field[y + 3][x + 3] == dot;
                }
            }
        }
        return false;
    }

    static boolean checkHo(int x, int y, char dot, int winCount) {
        if (isCellValid(x + winCount - 1, y)) {
            if (field[y][x] == dot && field[y][x + 1] == dot) {
                if (field[y][x + 2] == dot) {
                    return field[y][x + 3] == dot;
                }
            }
        }
        return false;
    }

    static boolean checkVe(int x, int y, char dot, int winCount) {
        if (isCellValid(x, y + winCount - 1)) {
            if (field[y][x] == dot && field[y + 1][x] == dot) {
                if (field[y + 2][x] == dot) {
                    return field[y + 3][x] == dot;
                }
            }
        }
        return false;
    }

    static boolean aiCheckHumanWin(int winCount) {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (isCellEmpty(x, y)) {
                    field[y][x] = DOT_HUMAN;
                    if (checkWin(DOT_HUMAN, winCount)) {
                        field[y][x] = DOT_AI;
                        return true;
                    }
                    field[y][x] = DOT_EMPTY;
                }
            }
        }
        return false;
    }
}
