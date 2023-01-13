package hw6;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView<Int> {
    private Controller controller = new Controller();


    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please,enter city: ");
            String city = scanner.nextLine();
            System.out.println("You enter " + city);


            System.out.println("Enter 1 for current weather;" +
                    "Enter 5 for weather during 5 days; Enter 2 for getting information from data; Enter 0 for exit:");


            String command = scanner.nextLine();
            System.out.println("You enter " + command);

            //TODO* Сделать метод валидации пользовательского ввода

            if (command.equals("0")) break;

            try {
                controller.getWeather(command, city);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}