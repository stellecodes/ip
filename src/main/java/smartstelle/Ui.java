package smartstelle;

import java.util.Scanner;

public class Ui {
    private final Scanner sc;

    public Ui() {
        sc = new Scanner(System.in);
    }

    public String readCommand() {
        return sc.nextLine();
    }

    public void showWelcome() {
        String logo = "  _____      _____\n" +
                " /          /     \n" +
                " \\_____    \\_____ \n" +
                "       \\         \\\n" +
                "  _____/   _____/\n";

        System.out.println(logo + "Hello! I am SmartStelle. What can I help you with?");
        showLine();
    }

    public void showGoodbye() {
        System.out.println("    Bye, talk to you next time!");
        showLine();
        sc.close();
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }

    public void showError(String msg) {
        System.out.println("\n**********************************\n" + msg + "\n**********************************\n");
    }

    public void showLine() {
        System.out.println("\n____________________________________________________________\n");
    }
}
