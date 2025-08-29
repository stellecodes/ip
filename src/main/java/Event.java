public class Event extends Task {
    private String start;
    private String end;

    public Event(String start, String end, String name, boolean isCompleted) throws StelleException {
        super(name, isCompleted);
        this.start = start;
        this.end = end;
    }

    @Override
    public String display() {
        return "[E]" + super.display() + " from " + start + " to " + end;
    }

    public String toSaveFormat() {
        return "E | " + (this.getIsCompleted() ? "1" : "0")
                + " | " + this.getName() + " | " + this.start + " | " + this.end;
    }
}
