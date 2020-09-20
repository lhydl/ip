package Duke;

import java.util.ArrayList;

public class TaskList {

    public static final ArrayList<Task> tasks = new ArrayList<>();

    public static void setDone(ArrayList<Task> tasks, String str) {
        try {
            String digit = str.replaceAll("[^0-9]", ""); //extract digit from a string
            int num = Integer.parseInt(digit); //change string to int
            if (num <= tasks.size() && num != 0) {
                tasks.get(num - 1).setAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("[" + tasks.get(num - 1).getStatusIcon() + "] " + tasks.get(num - 1).getDisplayString().trim() + System.lineSeparator());
            } else {
                System.out.println("Invalid tasks number." + System.lineSeparator());
            }
        } catch (Exception e) {
            Ui.printMissingTaskNumber();
        }
    }

    public static void deleteTasks(ArrayList<Task> tasks, String str) {
        try {
            String digit = str.replaceAll("[^0-9]", ""); //extract digit from a string
            int num = Integer.parseInt(digit); //change string to int
            if (num <= tasks.size() && num != 0) {
                System.out.println("Noted. I've removed this task:");
                System.out.println(tasks.get(num - 1));
                tasks.remove(num - 1);
                Ui.printNumberOfTasks(tasks);
            } else {
                System.out.println("Invalid tasks number." + System.lineSeparator());
            }
        } catch (Exception e) {
            Ui.printMissingTaskNumber();
        }
    }

    public static void addTodo(ArrayList<Task> tasks, String str) {
        if (str.toLowerCase().replace("todo", "").trim().equals("")) {
            System.out.println("\u2639 " + "OOPS!!! The description of a todo cannot be empty." + System.lineSeparator());
        } else {
            tasks.add(new Todo(str.toLowerCase().replace("todo", "")));
            Ui.printTaskAdded(tasks);
            Ui.printNumberOfTasks(tasks);
        }
    }

    public static void addDeadline(ArrayList<Task> tasks, String str) {
        String[] split = str.split("/"); //split string into two parts by
        try {
            if (split[0].toLowerCase().replace("deadline", "").trim().equals("")) {
                System.out.println("\u2639 " + "OOPS!!! The description of a deadline task cannot be empty." + System.lineSeparator());
            } else if (split[1].toLowerCase().replace("by", "").trim().equals("")) {
                System.out.println("\u2639 " + "OOPS!!! The deadline (by) of a deadline task cannot be empty." + System.lineSeparator());
            } else {
                tasks.add(new Deadline(split[0].toLowerCase().replace("deadline", ""), split[1].toLowerCase().replace("by", "")));
                Ui.printTaskAdded(tasks);
                Ui.printNumberOfTasks(tasks);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u2639 " + "OOPS!!! The description/deadline of a deadline task cannot be empty." + System.lineSeparator());
        }
    }

    public static void addEvent(ArrayList<Task> tasks, String str) {
        String[] split = str.split("/"); //split string into two parts by
        try {
            if (split[0].toLowerCase().replace("event", "").trim().equals("")) {
                System.out.println("\u2639 " + "OOPS!!! The description of a an event cannot be empty." + System.lineSeparator());
            } else if (split[1].toLowerCase().replace("at", "").trim().equals("")) {
                System.out.println("\u2639 " + "OOPS!!! The timing of a an event cannot be empty." + System.lineSeparator());
            } else {
                tasks.add(new Event(split[0].toLowerCase().replace("event", ""), split[1].toLowerCase().replace("at", "")));
                Ui.printTaskAdded(tasks);
                Ui.printNumberOfTasks(tasks);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u2639 " + "OOPS!!! The description/timing of an event cannot be empty." + System.lineSeparator());
        }
    }

}
