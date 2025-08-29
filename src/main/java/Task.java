public abstract class Task {
    private String taskName;
    private boolean completed;

    public Task(String taskName, boolean isCompleted) throws StelleException {
        if (taskName.isEmpty()) {
            throw new StelleException("Why you doing nothing.");
        }
        this.taskName = taskName;
        this.completed = isCompleted;
    }

    public String display() {
        return "[" + (completed ? "X" : " ") + "] " + this.taskName;
    }

    public String getName() {
        return taskName;
    }

    public boolean getIsCompleted() {
        return completed;
    }

    public void mark() {
        this.completed = true;
    }

    public void unmark() {
        this.completed = false;
    }

    public abstract String toSaveFormat();
}
