package smartstelle;

import java.util.ArrayList;

/**
 * Represents a list of tasks in the SmartStelle application.
 * <p>
 * This class manages an ArrayList of Task objects and provides
 * methods to add, display, mark, unmark, delete tasks, and
 * retrieve all tasks.
 */
public class TaskList {
    private ArrayList<Task> tasks;
    private int total = 0;

    /**
     * Constructs an empty TaskList.
     */
    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    /**
     * Constructs a TaskList with an existing list of tasks.
     *
     * @param tasks The initial list of tasks.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
        this.total = tasks.size();
    }

    /**
     * Adds a new task to the list.
     * <p>
     * Increments the total count and prints a message indicating the addition.
     *
     * @param task The task to add.
     */
    public void add(Task task) {
        this.total += 1;
        this.tasks.add(task);
        System.out.println(
                "    added new task: " + task.getName());
        System.out.println("Now you have " + total
                + " tasks in the list.\n\n____________________________________________________________\n");
    }

    /**
     * Displays all tasks in the list with numbering.
     */
    public void display() {
        for (int i = 0; i < this.tasks.size(); i++) {
            int num = i + 1;
            System.out.println("    " + num + "." + tasks.get(i).display());
        }
    }

    /**
     * Marks a task as completed based on its position in the list.
     * <p>
     * 
     * @param num The 1-based index of the task to mark as completed.
     */
    public void mark(int num) {
        this.tasks.get(num - 1).mark();
        System.out.println("Yay! I've marked this task as done:\n    " + this.tasks.get(num - 1).display());
    }

    /**
     * Marks a task as not completed based on its position in the list.
     * <p>
     * 
     * @param num The 1-based index of the task to unmark.
     */
    public void unmark(int num) {
        this.tasks.get(num - 1).unmark();
        System.out.println("Okay, I've marked this task as not done:\n    " + this.tasks.get(num - 1).display());
    }

    /**
     * Deletes a task from the list based on its position.
     * <p>
     * Decrements the total count and prints a message indicating the deletion.
     *
     * @param num The 1-based index of the task to delete.
     * @throws StelleException If the task number is invalid.
     */
    public void delete(int num) throws StelleException {
        if (num > this.tasks.size()) {
            throw new StelleException("That task doesn't even exist.");
        }
        Task task = this.tasks.get(num - 1);
        this.tasks.remove(num - 1);
        this.total -= 1;
        System.out.println("Okay, I've removed this task:\n    " + task.display());
        System.out.println("Now you have " + total
                + " tasks in the list.\n\n____________________________________________________________\n");
    }

    /**
     * Returns the entire list of tasks.
     *
     * @return An ArrayList containing all tasks.
     */
    public ArrayList<Task> getAll() {
        return this.tasks;
    }
}
