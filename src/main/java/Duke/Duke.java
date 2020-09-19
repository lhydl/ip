package Duke;

public class Duke {
    private static TaskList t;

    public static void main(String[] args) {
        Ui.printWelcomeScreen();
        TaskList.loadSavedData();
        run(t);
    }

    public static void run(TaskList t) {
        boolean isExit = false;
        while (!isExit) {
            String str = Ui.readCommand();
            Parser.parse(str, TaskList.tasks);
            if(str.trim().startsWith("bye")) {
                isExit = true;
            }
        }
    }

}
