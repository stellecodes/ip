public class ToDo extends Task {
    public ToDo(String name) throws StelleException {
        super(name);
    }

    @Override
    public String display() {
        return "[T]" + super.display();
    }
}
