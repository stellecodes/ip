import java.util.Scanner;

public class SmartStelle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String logo = "  _____      _____\n" +
                " /          /     \n" +
                " \\_____    \\_____ \n" +
                "       \\         \\\n" +
                "  _____/   _____/\n";

        String line = "\n____________________________________________________________\n";
        System.out.println(logo
                + "Hello! I am SmartStelle. What can I help you with?" + line);

        TaskList list = new TaskList();

        while (true) {
            String input = sc.nextLine();
            if (input.equals("bye")) {
                break;
            } else if (input.equals("list")) {
                list.display();
            } else {
                list.add(input);
            }
        }

        System.out.println("Bye, talk to you next time!");

        sc.close();
    }
}
