public class TaskList {
    private String[] tasks;

    public TaskList() {
        this.tasks = new String[100];
    }

    public void add(String task) {
        for (int i = 0; i < this.tasks.length; i++) {
            if (this.tasks[i] == null) {
                this.tasks[i] = task;
                System.out.println(
                        "\tadded new task: " + task
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
            System.out.println("\t" + num + ". " + tasks[i]);
        }
    }
}
