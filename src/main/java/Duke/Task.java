package Duke;

/**
 * Creates a Task object.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructor
     *
     * @param description name of task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Marks a task as done.
     */
    public void setAsDone() {
        isDone = true;
    }

    /**
     * Returns a cross if task is not done.
     * Returns a tick if task is done.
     *
     * @return tick or cross symbol
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    /**
     * Gets the name of the task.
     *
     * @return name of the task
     */
    public String getDisplayString() {
        return description;
    }

    /**
     * Formats the task when saving to a file.
     * Will be overridden by the type of tasks.
     *
     * @return null
     */
    public String saveDataFormat() {
        return null;
    }

    /**
     * Formats the display of tasks according to tasks type.
     *
     * @return the required display format depending on type of task
     */
    @Override
    public String toString() {
        return "[" + (isDone ? "\u2713" : "\u2718") + "] " + description.trim();
    }
}