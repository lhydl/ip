package Duke;

import java.util.ArrayList;

public class Parser {
    protected static boolean exit = false;

    public static void parse(String str, ArrayList<Task> tasks) {
        String[] spl = str.trim().split(" "); //split the command from the rest of the string
        if (str.trim().startsWith("todo") && spl[0].equals("todo")) {
            TaskList.addTodo(tasks, str);
            Storage.saveData(tasks);
        } else if (str.trim().startsWith("deadline") && spl[0].equals("deadline") ) {
            TaskList.addDeadline(tasks, str);
            Storage.saveData(tasks);
        } else if (str.trim().startsWith("event") && spl[0].equals("event")) {
            TaskList.addEvent(tasks, str);
            Storage.saveData(tasks);
        } else if (str.trim().startsWith("list") && spl[0].equals("list")) {
            TaskList.printList(tasks);
        } else if (str.trim().startsWith("done") && spl[0].equals("done")) {
            TaskList.setDone(tasks, str);
            Storage.saveData(tasks);
        } else if (str.trim().startsWith("delete") && spl[0].equals("delete")) {
            TaskList.deleteTasks(tasks, str);
            Storage.saveData(tasks);
        } else if (str.trim().startsWith("bye") && spl[0].equals("bye")) {
            System.out.println("Bye. Hope to see you again soon!\n");
            exit = true;
        } else {
            System.out.println("\u2639 " + "OOPS!!! I'm sorry, but I don't know what that means :-(" + System.lineSeparator());
        }
    }

    public static boolean isExit() {
        return exit;
    }

}
