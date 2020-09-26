package Duke;

/**
 * Creates a Deadline task.
 */
public class Deadline extends Task {
    protected String by;

    /**
     * Constructor
     *
     * @param description name of task
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Formats the task when saving to a file.
     *
     * @return the required format when saving to a file
     */
    public String saveDataFormat() {
        return "D | " + (isDone? "1" : "0") + " | " + description + " | " + by;
    }

    /**
     * Gets the details of the task.
     *
     * @return the description and time of the task.
     */
    @Override
    public String getDisplayString() {
        return description + by;
    }

    /**
     * Formats the display of tasks.
     *
     * @return the required display format
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.trim() + ")";
    }
}