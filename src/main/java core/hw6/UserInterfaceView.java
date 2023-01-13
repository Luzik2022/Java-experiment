package hw6;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please,enter city: ");
            String city = scanner.nextLine();
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter letters:");
            while (!sc.hasNext("[A-Za-z]+")) {
                System.out.println("Nope, that's not it!");
                sc.next();
            }
            String word = sc.next();
            System.out.println("Thank you! Got " + word);

            System.out.println("Enter 1 for current weather;" +
                    "Enter 5 for weather during 5 days; Enter 2 for getting information from data; Enter 0 for exit:");

            String command = scanner.nextLine();


            if (command.equals("0")) break;

            try {
                controller.getWeather(command, city);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
