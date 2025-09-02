package smartstelle;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;
    private int total = 0;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
        this.total = tasks.size();
    }

    public void add(Task task) {
        this.total += 1;
        this.tasks.add(task);
        System.out.println(
                "    added new task: " + task.getName());
        System.out.println("Now you have " + total
                + " tasks in the list.\n\n____________________________________________________________\n");
    }

    public void display() {
        for (int i = 0; i < this.tasks.size(); i++) {
            int num = i + 1;
            System.out.println("    " + num + "." + tasks.get(i).display());
        }
    }

    public void mark(int num) {
        this.tasks.get(num - 1).mark();
        System.out.println("Yay! I've marked this task as done:\n    " + this.tasks.get(num - 1).display());
    }

    public void unmark(int num) {
        this.tasks.get(num - 1).unmark();
        System.out.println("Okay, I've marked this task as not done:\n    " + this.tasks.get(num - 1).display());
    }

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

    public ArrayList<Task> getAll() {
        return this.tasks;
    }

    public void printTasksWithKeyword(String keyword) {
        ArrayList<Task> selectedTasks = new ArrayList<>();
        for (Task task : this.tasks) {
            if (task.matches(keyword)) {
                selectedTasks.add(task);
            }
        }

        TaskList selectedTasksList = new TaskList(selectedTasks);
        selectedTasksList.display();
    }
}
