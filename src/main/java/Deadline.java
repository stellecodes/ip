import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private LocalDateTime date;

    public Deadline(String name, String date, boolean isCompleted) throws StelleException {
        super(name, isCompleted);
        this.date = LocalDateTime.parse(date);
    }

    private String formatDate() {
        return this.date.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm"));
    }

    @Override
    public String display() {
        return "[D]" + super.display() + " by " + formatDate();
    }

    public String toSaveFormat() {
        return "D | " + (this.getIsCompleted() ? "1" : "0")
                + " | " + this.getName() + " | " + this.date;
    }
}
