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
        case "done":
            TaskList.setDone(tasks, str);
            Storage.saveData(tasks);
            break;
        case "delete":
            TaskList.deleteTasks(tasks, str);
            Storage.saveData(tasks);
            break;
        case "find":
            TaskList.findTasks(tasks, str);
            break;
        case "list":
            if(str.trim().length()>4) {
                Ui.printInvalidCommand();
            } else {
                Ui.printList(tasks);
            }
            break;
        case "bye":
            if(str.trim().length()>3) {
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

    public static boolean isExit() {
        return exit;
    }

}
