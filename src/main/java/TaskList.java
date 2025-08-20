public class TaskList {
    private Task[] tasks;

    public TaskList() {
        this.tasks = new Task[100];
    }

    public void add(String taskName) {
        for (int i = 0; i < this.tasks.length; i++) {
            if (this.tasks[i] == null) {
                this.tasks[i] = new Task(taskName);
                System.out.println(
                        "\tadded new task: " + taskName
                                + "\n\n____________________________________________________________\n");
                break;
            }
        }
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
