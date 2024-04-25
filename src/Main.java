import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Would you like to access a business or personal bank menu? B or P");
        String choice = scanner.nextLine();
        if (choice.equals("P")) {
            System.out.println("you are accessing a personal bank menu");
            Menu menu = new Menu();
            menu.runMenu();
        } else {
            System.out.println("You are accessing a business bank menu");
            businessMenu menu = new businessMenu();
            menu.runMenu();
        }
    }
}
