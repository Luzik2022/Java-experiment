package lesson1;

public class homeWorkApp {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }


    private static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    private static void checkSumSign() {
        int varA = 6;
        int varB = 4;
        int result = varA + varB;

        System.out.println(varA + varB);

        if (result >= 0) {
            System.out.println("Сумма положительная");
        }
        if (result < 0) {
            System.out.println("Сумма отрицательная");
        }
    }

    private static void printColor() {
        int value = 100;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value >0 && value == 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
            System.out.println("Зеленый");
        }
    }

    private static void compareNumbers() {
        int VarA = 3;
        int VarB = 2;

        if (VarA > VarB || VarA == VarB){
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

}

