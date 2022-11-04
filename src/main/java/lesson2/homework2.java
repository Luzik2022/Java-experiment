package lesson2;

public class homework2 {

    public static void main(String[] args) {
        boolean sum10to20 = within10and20(10,3);
        System.out.println(sum10to20);
        isPositiveOrNegative(-1);
        boolean number = isNegative(8);
        System.out.println(number);
        printWordNTimes("Happy",3);

    }

    private static boolean within10and20(int x1, int x2) {
        int result = x1 + x2;
        System.out.println(result);
        if (result >= 10 && result <= 20) {
            System.out.println("Сумма в пределах от 10 до 20");
            return true;
        }
        if (result < 10 || result > 20) {
            System.out.println("Сумма не в пределах от 10 до 20");
            return false;
        }
        return true;
    }
    private static void isPositiveOrNegative(int x) {
        if(x >=0){
            System.out.println("Положительное число");
        }
        if (x < 0) {
            System.out.println("Отрицательное число");
        }

    }

    private static boolean isNegative(int x) {
        if (x < 0) {
            System.out.println("Отрицательное число");
            return true;
        }
        if (x > 0){
          System.out.println("Положительное число");
          return false;
        }
        return false;
    }

    private static void printWordNTimes(String word,int times) {
        for (int i = 1; i <=times; i++) {
            System.out.println("[" + i + "]" +word);
        }
        System.out.println("End");
    }

}
