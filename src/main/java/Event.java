import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private LocalDateTime start;
    private LocalDateTime end;

    public Event(String start, String end, String name, boolean isCompleted) throws StelleException {
        super(name, isCompleted);
        this.start = LocalDateTime.parse(start);
        this.end = LocalDateTime.parse(end);
    }

    private String formatDate() {
        return "from " + this.start.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm")) + " to "
                + this.end.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm"));
    }

    @Override
    public String display() {
        return "[E]" + super.display() + " " + this.formatDate();
    }

    public String toSaveFormat() {
        return "E | " + (this.getIsCompleted() ? "1" : "0")
                + " | " + this.getName() + " | " + this.start + " | " + this.end;
    }
}
