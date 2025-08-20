public class ToDo extends Task {
    public ToDo(String name) {
        super(name);
    }

    @Override
    public String display() {
        return "[T]" + super.display();
    }
}
