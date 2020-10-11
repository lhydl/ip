package Duke;

/**
 * Entry point of the Duke program.
 * Initializes the program and starts the interaction with the user.
 */
public class Duke {
    private static TaskList t;

    public static void main(String[] args) {
        Ui.printWelcomeScreen();
        Storage.loadSavedData(TaskList.tasks);
        Ui.printPrompt();
        run(t);
    }

    /**
     * Runs the program until termination.
     *
     * @param t TaskList t
     */
    public static void run(TaskList t) {
        while (!Parser.isExit()) {
            String input = Ui.readCommand();
            Parser.parse(input, TaskList.tasks);
        }
    }
}
