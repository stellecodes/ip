import java.util.Scanner;

public class SmartStelle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String logo = "  _____      _____\n" +
                " /          /     \n" +
                " \\_____    \\_____ \n" +
                "       \\         \\\n" +
                "  _____/   _____/\n";
        System.out.println(logo + "Hello! I am SmartStelle. What can I help you with?");

        while (true) {
            String input = sc.nextLine();
            if (input.equals("bye")) {
                break;
            } else {
                System.out.println(input);
            }
        }

        System.out.println("Bye, talk to you next time!");

        sc.close();
    }
}
