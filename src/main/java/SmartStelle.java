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

        Storage storage = new Storage("./data/duke.txt");
        TaskList list;
        try {
            list = new TaskList(storage.load());
        } catch (Exception e) {
            System.out.println("Starting fresh (couldn't read save file).");
            list = new TaskList();
        }

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
                    storage.save(list.getAll());
                    System.out.println(line);
                } else if (input.startsWith("unmark")) {
                    String taskNum = input.substring(7);
                    int num = Integer.parseInt(taskNum); // convert String to int
                    list.unmark(num);
                    storage.save(list.getAll());
                    System.out.println(line);
                } else if (input.startsWith("todo")) {
                    String task = input.substring(4);
                    list.add(new ToDo(task, false));
                    storage.save(list.getAll());
                } else if (input.startsWith("deadline")) {
                    String[] parts = input.substring(8).split(" /by");
                    if (parts.length == 1) {
                        throw new StelleException("Why no deadline.");
                    }
                    list.add(new Deadline(parts[0], parts[1], false));
                    storage.save(list.getAll());
                } else if (input.startsWith("event")) {
                    String[] parts = input.substring(5).split(" /");
                    if (parts.length < 2) {
                        throw new StelleException("Why you dk how long.");
                    }
                    list.add(new Event(parts[1].substring(5), parts[2].substring(3), parts[0], false));
                    storage.save(list.getAll());
                } else if (input.startsWith("delete")) {
                    String numberString = input.substring(6);
                    if (numberString.isEmpty()) {
                        throw new StelleException("Why you deleting nothing.");
                    }
                    int num = Integer.parseInt(numberString.substring(1));
                    list.delete(num);
                    storage.save(list.getAll());
                } else {
                    System.out.println("\nWhat are you saying..............\n");
                }
            } catch (Exception e) {
                System.out.println("\n**********************************\n");
                System.out.println(e.getMessage());
                System.out.println("\n**********************************\n");
            }
        }

        System.out.println("    Bye, talk to you next time!" + line);

        sc.close();
    }
}
