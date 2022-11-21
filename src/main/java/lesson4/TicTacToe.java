package lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static int size;
    private static int winSize;
    private static final char DOT_EMPTY = '•';
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    public static final String HEADER_FIRST_SYMBOL = "*";
    public static final String SPACE_MAP_SYMBOL = " ";
    private static char[][] MAP = new char[size][size];
    private static final Scanner in = new Scanner(System.in);
    private static final Random random = new Random();
    private static int turnsCount = 0;
    private static String string;

    public static void main(String[] args) {
        start();
    }
    public static void start() {
        do {
            System.out.println("\n\nИгра начинается!");
            init();
            printMap();
            playGame();
        } while (isContinueGame());
    }
    private static void init() {
        turnsCount = 0;
        size = getSizeFromUser();
        winSize = getWinsize();
        initMap();
    }
    private static int getWinsize() {
        if(size >= 3 && size <= 6) {
            return 3;
        } else if(size > 6 && size <= 10) {
            return 4;
        }
        return 5;
    }
    private static int getSizeFromUser() {
        System.out.println("Необходимо выбрать размер игрового поля");
        return getValidNumberFromScanner(3,9);
    }
    private static boolean isContinueGame() {
        System.out.println("Хотите продолжить? yes\\no");
        return switch(in.next()){
            case "y","n","у","+","да","нет" -> true;
            default -> false;
        };
    }
    private static void initMap() {
        MAP = new char[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }
    private static void printMap() {
        printHeaderMap();
        printBodyMap();
    }
    private static void printHeaderMap() {
        System.out.print(HEADER_FIRST_SYMBOL + SPACE_MAP_SYMBOL);
        for (int i = 0; i < size; i++) {
            PrintMapNumber(i);
        }
        System.out.println();
    }
    private static void PrintMapNumber(int i) {
        System.out.print(i + 1 + SPACE_MAP_SYMBOL);
    }
    private static void printBodyMap() {
        for (int i = 0; i < size; i++) {
            PrintMapNumber(i);
            for (int j = 0; j < size; j++) {
                System.out.print(MAP[i][j] + SPACE_MAP_SYMBOL);
            }
            System.out.println();
        }
    }
    private static void playGame() {
        while (true) {
            humanturn();
            printMap();
            if(checkEnd(DOT_HUMAN)){
                break;
            }
            aiTurn();
            printMap();
            if(checkEnd(DOT_AI)){
                break;
            }
        }
    }
    private static void aiTurn() {
        System.out.println("\nХОД КОМПЬЮТЕРА!");
        int rowNumber;
        int columnNumber;

       do {
            rowNumber = random.nextInt(size);
            columnNumber = random.nextInt(size);
        } while(!isCellFree(rowNumber, columnNumber));

        MAP [rowNumber] [columnNumber] = DOT_AI;
        turnsCount++;
    }

    private static void humanturn() {
        System.out.println("\nХОД ЧЕЛОВЕКА!");
        int rowNumber;
        int columnNumber;

        while (true) {
            System.out.println("Введите координату строки: ");
            rowNumber = getValidNumberMapLineFromScanner();
            System.out.println("Введите координату столбца: ");
            columnNumber = getValidNumberMapLineFromScanner();

            if (isCellFree(rowNumber, columnNumber)) {
                break;
            }
            System.out.printf("Ошибка! Ячейка с координатами %s:%s уже используются%n", rowNumber + 1,columnNumber + 1);
        }
        MAP [rowNumber] [columnNumber] = DOT_HUMAN;
        turnsCount++;
    }
    private static int getValidNumberMapLineFromScanner() {
        return getValidNumberFromScanner(1,size) - 1;
    }
    private static int getValidNumberFromScanner(int min, int max) {
        while(true){
            System.out.print("Введите число: ");
            if(in.hasNextInt()){
                int n = in.nextInt();
                if(isNumberValid(n,min,max)){
                    return n;
                }
                System.out.printf("Ошибка!Проверьте значение координаты.Должно быть от %s до %s. Введено: %s%n",
                        min,max,n);
            } else {
                System.out.printf("Ошибка!Ввод допускает лишь целые числа. %s - не целое число!%n", in.next());
            }
        }
    }
    private static boolean isNumberValid(int n, int min, int max) {
        return n >= min && n <= max;
    }
    private static boolean checkEnd(char symbol) {
        if(checkWin(symbol)) {
            if(symbol == DOT_HUMAN) {
                System.out.println("Ура! Вы победили!");
            } else {
                System.out.println("Восстание близко.....Скайнет победил");
            }
            return true;
        }

        if(checkDraw()){
            System.out.println("Ничья");
            return true;
        }
        return false;
    }

    private static boolean checkDraw() {
        return turnsCount >= size * size;
    }

    private static boolean checkWin(char symbol) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (checkLine(i, j, 0, 1, symbol)) return true;
                if (checkLine(i, j, 1, 1, symbol)) return true;
                if (checkLine(i, j, 1, 0, symbol)) return true;
                if (checkLine(i, j, -1, 1, symbol)) return true;
            }
        }
        return false;
        }
    private static boolean checkLine(int y, int x, int yDirection, int xDirection, char symbol) {
        int wayX = x + (size - 1) * xDirection;
        int wayY = y + (size - 1) * yDirection;
        if (wayX < 0 || wayY < 0 || wayX > size - 1 || wayY > size - 1) return false;
        for (int i = 0; i < size; i++) {
            if (MAP[y + i * yDirection][x + i * xDirection] != symbol) return false;
        }
        return true;
    }
    private static boolean isCellFree(int rowNumber, int columnNumber) {
        return MAP [rowNumber][columnNumber] == DOT_EMPTY;
    }
}

