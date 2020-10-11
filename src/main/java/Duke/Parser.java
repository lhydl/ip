package Duke;

import java.util.ArrayList;

/**
 * Parses user input
 */
public class Parser {
    public static final String COMMAND_TODO = "todo";
    public static final String COMMAND_DEADLINE = "deadline";
    public static final String COMMAND_EVENT = "event";
    public static final String COMMAND_DONE = "done";
    public static final String COMMAND_DELETE = "delete";
    public static final String COMMAND_FIND = "find";
    public static final String COMMAND_LIST = "list";
    public static final String COMMAND_BYE = "bye";
    public static final int COMMAND_LIST_LENGTH = 4;
    public static final int COMMAND_BYE_LENGTH = 3;

    protected static boolean exit = false;

    /**
     * Parses user input for execution.
     * Command words are case insensitive.
     *
     * @param str input entered by user
     * @param tasks task list
     */
    public static void parse(String str, ArrayList<Task> tasks) {

        String[] command = str.trim().split(" "); //split the command from the rest of the string

        switch (command[0].toLowerCase()) {
        case COMMAND_TODO:
            TaskList.addTodo(tasks, str);
            Storage.saveData(tasks);
            break;
        case COMMAND_DEADLINE:
            TaskList.addDeadline(tasks, str);
            Storage.saveData(tasks);
            break;
        case COMMAND_EVENT:
            TaskList.addEvent(tasks, str);
            Storage.saveData(tasks);
            break;
        case COMMAND_DONE:
            TaskList.setDone(tasks, str);
            Storage.saveData(tasks);
            break;
        case COMMAND_DELETE:
            TaskList.deleteTasks(tasks, str);
            Storage.saveData(tasks);
            break;
        case COMMAND_FIND:
            TaskList.findTasks(tasks, str);
            break;
        case COMMAND_LIST:
            if(str.trim().length() > COMMAND_LIST_LENGTH) {
                Ui.printInvalidCommand();
            } else {
                Ui.printList(tasks);
            }
            break;
        case COMMAND_BYE:
            if(str.trim().length() > COMMAND_BYE_LENGTH) {
                Ui.printInvalidCommand();
            } else {
                Ui.printExitScreen();
                exit = true;
            }
            break;
        default:
            Ui.printInvalidCommand();
        }
    }

    /**
     * Returns true if user types in "bye".
     *
     * @return status of exit
     */
    public static boolean isExit() {
        return exit;
    }

}
