public class Deadline extends Task {
    private String date;

    public Deadline(String name, String date, boolean isCompleted) throws StelleException {
        super(name, isCompleted);
        this.date = date;
    }

    @Override
    public String display() {
        return "[D]" + super.display() + " by" + date;
    }

    public String toSaveFormat() {
        return "D | " + (this.getIsCompleted() ? "1" : "0")
                + " | " + this.getName() + " | " + this.date;
    }
}
