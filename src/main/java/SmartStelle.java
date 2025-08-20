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
            try {
                if (input.equals("bye")) {
                    break;
                } else if (input.equals("list")) {
                    list.display();
                    System.out.println(line);
                } else if (input.startsWith("mark")) {
                    String taskNum = input.substring(5);
                    int num = Integer.parseInt(taskNum); // convert String to int
                    list.mark(num);
                    System.out.println(line);
                } else if (input.startsWith("unmark")) {
                    String taskNum = input.substring(7);
                    int num = Integer.parseInt(taskNum); // convert String to int
                    list.unmark(num);
                    System.out.println(line);
                } else if (input.startsWith("todo")) {
                    String task = input.substring(4);
                    list.add(new ToDo(task));
                } else if (input.startsWith("deadline")) {
                    String[] parts = input.substring(8).split(" /by");
                    if (parts.length == 1) {
                        throw new StelleException("Why no deadline.");
                    }
                    list.add(new Deadline(parts[0], parts[1]));
                } else if (input.startsWith("event")) {
                    String[] parts = input.substring(5).split(" /");
                    if (parts.length < 2) {
                        throw new StelleException("Why you dk how long.");
                    }
                    list.add(new Event(parts[1].substring(5), parts[2].substring(3), parts[0]));
                } else if (input.startsWith("delete")) {
                    String numberString = input.substring(6);
                    if (numberString.isEmpty()) {
                        throw new StelleException("Why you deleting nothing.");
                    }
                    int num = Integer.parseInt(numberString.substring(1));
                    list.delete(num);
                } else {
                    System.out.println("\nWhat are you saying..............\n");
                }
            } catch (StelleException e) {
                System.out.println("\n**********************************\n");
                System.out.println(e.getMessage());
                System.out.println("\n**********************************\n");
            }
        }

        System.out.println("\tBye, talk to you next time!" + line);

        sc.close();
    }
}
