package smartstelle;

import java.io.IOException;

/**
 * The Parser class is responsible for interpreting user input commands
 * and executing corresponding actions on the TaskList, Storage, and UI.
 * 
 * It handles commands such as adding tasks, marking/unmarking tasks,
 * deleting tasks, listing tasks, and exiting the program.
 */
public class Parser {

    /**
     * Parses and executes a user command.
     *
     * @param input   The user input command as a string.
     * @param list    The TaskList containing all current tasks.
     * @param storage The Storage object for saving tasks to file.
     * @param ui      The Ui object for displaying messages and lines.
     * @return -1 if the input is "bye" (to signal program exit), otherwise 0.
     * @throws IOException     If an error occurs when saving to storage.
     * @throws StelleException If the user input is invalid or incomplete (e.g.,
     *                         missing deadline or event duration).
     */
    public static String parse(String input, TaskList list, Storage storage, Ui ui) throws IOException, StelleException {
        if (input.equals("bye")) {
            return "bye";
        } else if (input.equals("list")) {
            return list.display();
        } else if (input.startsWith("mark")) {
            String taskNum = input.substring(5);
            int num = Integer.parseInt(taskNum); // convert String to int
            String msg = list.mark(num);
            storage.save(list.getAll());
            return msg;
        } else if (input.startsWith("unmark")) {
            String taskNum = input.substring(7);
            int num = Integer.parseInt(taskNum); // convert String to int
            String msg = list.unmark(num);
            storage.save(list.getAll());
            return msg;
        } else if (input.startsWith("todo")) {
            String task = input.substring(4).trim();
            String msg = list.add(new ToDo(task, false));
            storage.save(list.getAll());
            return msg;
        } else if (input.startsWith("deadline")) {
            String[] parts = input.substring(8).trim().split("\\s*/by\\s+", 2);
            if (parts.length == 1) {
                throw new StelleException("Why no deadline.");
            }
            String msg = list.add(new Deadline(parts[0], parts[1], false));
            storage.save(list.getAll());
            return msg;
        } else if (input.startsWith("event")) {
            String[] parts = input.substring(6).split(" /");
            if (parts.length < 2) {
                throw new StelleException("Why you dk how long.");
            }
            String msg = list.add(new Event(parts[1].substring(5), parts[2].substring(3), parts[0], false));
            storage.save(list.getAll());
            return msg;
        } else if (input.startsWith("delete")) {
            String numberString = input.substring(6);
            if (numberString.isEmpty()) {
                throw new StelleException("Why you deleting nothing.");
            }
            int num = Integer.parseInt(numberString.substring(1));
            String msg = list.delete(num);
            storage.save(list.getAll());
            return msg;
        } else if (input.startsWith("find")) {
            String keyword = input.substring(5);
            return list.getTasksWithKeyword(keyword);
        } else {
            return "What are you saying..............\n";
        }
    }
}
