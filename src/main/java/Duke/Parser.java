package Duke;

import java.util.ArrayList;

public class Parser {

    public static void parse(String str, ArrayList<Task> tasks) {
        String[] spl = str.trim().split(" "); //split the command from the rest of the string
        if (str.trim().startsWith("todo") && spl[0].equals("todo")) {
            Duke.addTodo(tasks, str);
            Duke.saveData();
        } else if (str.trim().startsWith("deadline") && spl[0].equals("deadline") ) {
            Duke.addDeadline(tasks, str);
            Duke.saveData();
        } else if (str.trim().startsWith("event") && spl[0].equals("event")) {
            Duke.addEvent(tasks, str);
            Duke.saveData();
        } else if (str.trim().startsWith("list") && spl[0].equals("list")) {
            Duke.printList(tasks);
        } else if (str.trim().startsWith("done") && spl[0].equals("done")) {
            Duke.setDone(tasks, str);
            Duke.saveData();
        } else if (str.trim().startsWith("delete") && spl[0].equals("delete")) {
            Duke.deleteTasks(tasks, str);
            Duke.saveData();
        } else if (str.trim().startsWith("bye") && spl[0].equals("bye")) {
            System.out.println("Bye. Hope to see you again soon!\n");
        } else {
            System.out.println("\u2639 " + "OOPS!!! I'm sorry, but I don't know what that means :-(" + System.lineSeparator());
        }
    }

}
