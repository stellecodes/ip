public class ToDo extends Task {
    public ToDo(String name, boolean isCompleted) throws StelleException {
        super(name, isCompleted);
    }

    @Override
    public String display() {
        return "[T]" + super.display();
    }

    public String toSaveFormat() {
        return "T | " + (this.getIsCompleted() ? "1" : "0") + " | " + this.getName();
    }
}
