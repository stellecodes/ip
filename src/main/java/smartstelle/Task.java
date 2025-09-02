package smartstelle;

public abstract class Task {
    private String taskName;
    private boolean isCompleted;

    public Task(String taskName, boolean isCompleted) throws StelleException {
        if (taskName.isEmpty()) {
            throw new StelleException("Why you doing nothing.");
        }
        this.taskName = taskName;
        this.isCompleted = isCompleted;
    }

    public String display() {
        return "[" + (isCompleted ? "X" : " ") + "] " + this.taskName;
    }

    public String getName() {
        return taskName;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void mark() {
        this.isCompleted = true;
    }

    public void unmark() {
        this.isCompleted = false;
    }

    public boolean matches(String keyword) {
        return this.taskName.toLowerCase().contains(keyword.toLowerCase());
    }

    public abstract String toSaveFormat();
}
