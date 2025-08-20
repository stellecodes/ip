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
            System.out.println("\t" + num + ". " + tasks[i].getName());
        }
    }
}
