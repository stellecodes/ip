package smartstelle;

import java.io.IOException;

public class Parser {
    public static int parse(String input, TaskList list, Storage storage, Ui ui) throws IOException, StelleException {
        if (input.equals("bye")) {
            return -1;
        } else if (input.equals("list")) {
            list.display();
            ui.showLine();
        } else if (input.startsWith("mark")) {
            String taskNum = input.substring(5);
            int num = Integer.parseInt(taskNum); // convert String to int
            list.mark(num);
            storage.save(list.getAll());
            ui.showLine();
        } else if (input.startsWith("unmark")) {
            String taskNum = input.substring(7);
            int num = Integer.parseInt(taskNum); // convert String to int
            list.unmark(num);
            storage.save(list.getAll());
            ui.showLine();
        } else if (input.startsWith("todo")) {
            String task = input.substring(4).trim();
            list.add(new ToDo(task, false));
            storage.save(list.getAll());
        } else if (input.startsWith("deadline")) {
            String[] parts = input.substring(8).trim().split("\\s*/by\\s+", 2);
            if (parts.length == 1) {
                throw new StelleException("Why no deadline.");
            }
            list.add(new Deadline(parts[0], parts[1], false));
            storage.save(list.getAll());
        } else if (input.startsWith("event")) {
            String[] parts = input.substring(6).split(" /");
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
        return 0;
    }
}
