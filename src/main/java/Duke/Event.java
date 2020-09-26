package Duke;

/**
 * Creates an Event task.
 */
public class Event extends Task {
    protected String at;

    /**
     * Constructor
     *
     * @param description name of task
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    /**
     * Formats the task when saving to a file.
     *
     * @return the required format when saving to a file
     */
    public String saveDataFormat() {
        return "E | " + (isDone? "1" : "0") + " | " + description + " | " + at;
    }

    /**
     * Gets the details of the task.
     *
     * @return the description and time of the task.
     */
    @Override
    public String getDisplayString() {
        return description + at;
    }

    /**
     * Formats the display of tasks.
     *
     * @return the required display format
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at.trim() + ")";
    }
}
