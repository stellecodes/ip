public class Event extends Task {
    private String start;
    private String end;

    public Event(String start, String end, String name) {
        super(name);
        this.start = start;
        this.end = end;
    }
}
