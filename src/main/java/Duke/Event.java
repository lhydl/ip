package Duke;

public class Event extends Task {
    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    public String saveDataFormat() {
        return "E | " + (isDone? "1" : "0") + " | " + description + " | " + at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at.trim() + ")";
    }
}
