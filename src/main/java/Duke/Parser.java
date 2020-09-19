package Duke;

import java.util.ArrayList;

public class Parser {
    protected static boolean exit = false;

    public static void parse(String str, ArrayList<Task> tasks) {

        String[] command = str.trim().split(" "); //split the command from the rest of the string

        switch (command[0].toLowerCase()) {
        case "todo":
            TaskList.addTodo(tasks, str);
            Storage.saveData(tasks);
            break;
        case "deadline":
            TaskList.addDeadline(tasks, str);
            Storage.saveData(tasks);
            break;
        case "event":
            TaskList.addEvent(tasks, str);
            Storage.saveData(tasks);
            break;
        case "list":
            TaskList.printList(tasks);
            break;
        case "done":
            TaskList.setDone(tasks, str);
            Storage.saveData(tasks);
            break;
        case "delete":
            TaskList.deleteTasks(tasks, str);
            Storage.saveData(tasks);
            break;
        case "bye":
            Ui.printExitScreen();
            exit = true;
            break;
        default:
            Ui.printInvalidCommand();
        }
    }

    public static boolean isExit() {
        return exit;
    }

}
