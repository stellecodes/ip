public class TaskList {
    private Task[] tasks;
    private int total = 0;

    public TaskList() {
        this.tasks = new Task[100];
    }

    public void add(Task task) {
        this.total += 1;
        for (int i = 0; i < this.tasks.length; i++) {
            if (this.tasks[i] == null) {
                this.tasks[i] = task;
                System.out.println(
                        "\tadded new task: " + task.getName());
                break;
            }
        }
        System.out.println("Now you have " + total
                + " tasks in the list.\n\n____________________________________________________________\n");
    }

    public void display() {
        for (int i = 0; i < this.tasks.length; i++) {
            if (tasks[i] == null) {
                break;
            }
            int num = i + 1;
            System.out.println("\t" + num + "." + tasks[i].display());
        }
    }

    public void mark(int num) {
        if (this.tasks[num - 1] == null) {
            System.out.println("\tThere is no task " + num);
            return;
        }
        this.tasks[num - 1].mark();
        System.out.println("Yay! I've marked this task as done:\n\t" + this.tasks[num - 1].display());
    }

    public void unmark(int num) {
        if (this.tasks[num - 1] == null) {
            System.out.println("\tThere is no task " + num);
            return;
        }
        this.tasks[num - 1].unmark();
        System.out.println("Okay, I've marked this task as not done:\n\t" + this.tasks[num - 1].display());
    }
}
