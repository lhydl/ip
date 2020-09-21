package Duke;

/**
 * Creates a Todo task.
 */
public class Todo extends Task {

    /**
     * Constructor
     *
     * @param description name of task
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Formats the task when saving to a file.
     *
     * @return the required format when saving to a file
     */
    public String saveDataFormat() {
        return "T | " + (isDone? "1" : "0") + " | " + description;
    }

    /**
     * Formats the display of tasks.
     *
     * @return the required display format
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
