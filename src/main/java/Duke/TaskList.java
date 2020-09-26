package Duke;

import java.util.ArrayList;

/**
 * Contains the task list and operations to manipulate the tasks.
 */
public class TaskList {

    public static ArrayList<Task> tasks = new ArrayList<>();
    private static final String SAD_FACE = "\u2639";

    /**
     * Marks a selected task as done.
     * Can only take in one task number at a time.
     *
     * @param tasks task list
     * @param str input entered by user
     */
    public static void setDone(ArrayList<Task> tasks, String str) {
        try {
            String digit = str.replaceAll("[^0-9]", ""); //extract digit from a string
            int num = Integer.parseInt(digit); //change string to int
            if (num <= tasks.size() && num != 0) {
                tasks.get(num - 1).setAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(tasks.get(num - 1) + System.lineSeparator());
            } else {
                System.out.println("Invalid task number." + System.lineSeparator());
            }
        } catch (Exception e) {
            Ui.printMissingTaskNumber();
        }
    }

    /**
     * Deletes a selected task from the task list.
     * Can only take in one task number at a time.
     *
     * @param tasks task list
     * @param str input entered by user
     */
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
                System.out.println("Invalid task number." + System.lineSeparator());
            }
        } catch (Exception e) {
            Ui.printMissingTaskNumber();
        }
    }

    /**
     * Adds a task type of Todo to the task list.
     *
     * @param tasks task list
     * @param str input entered by user
     */
    public static void addTodo(ArrayList<Task> tasks, String str) {
        if (str.toLowerCase().replace("todo", "").trim().equals("")) {
            System.out.println(SAD_FACE + " OOPS!!! The description of a todo cannot be empty." + System.lineSeparator());
        } else {
            tasks.add(new Todo(str.toLowerCase().replace("todo", "")));
            Ui.printTaskAdded(tasks);
            Ui.printNumberOfTasks(tasks);
        }
    }

    /**
     * Adds a task type of Deadline to the task list.
     *
     * @param tasks task list
     * @param str input entered by user
     */
    public static void addDeadline(ArrayList<Task> tasks, String str) {
        String[] split = str.split("/by"); //split string into two parts by
        try {
            if (split[0].toLowerCase().replace("deadline", "").trim().equals("")) {
                System.out.println(SAD_FACE + " OOPS!!! The task name of a deadline task cannot be empty." + System.lineSeparator());
            } else if (split[1].toLowerCase().replace("by", "").trim().equals("")) {
                System.out.println(SAD_FACE + " OOPS!!! The time of a deadline task cannot be empty." + System.lineSeparator());
            } else {
                tasks.add(new Deadline(split[0].toLowerCase().replace("deadline", ""), split[1].toLowerCase().replace("by", "")));
                Ui.printTaskAdded(tasks);
                Ui.printNumberOfTasks(tasks);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(SAD_FACE + " OOPS!!! Wrong format entered for deadline task.");
            System.out.println("Format: event <task name> /by <time>" + System.lineSeparator());
        }
    }

    /**
     * Adds a task type of Event to the task list.
     *
     * @param tasks task list
     * @param str input entered by user
     */
    public static void addEvent(ArrayList<Task> tasks, String str) {
        String[] split = str.split("/at"); //split string into two parts by
        try {
            if (split[0].toLowerCase().replace("event", "").trim().equals("")) {
                System.out.println(SAD_FACE + " OOPS!!! The task name of an event cannot be empty." + System.lineSeparator());
            } else if (split[1].toLowerCase().replace("at", "").trim().equals("")) {
                System.out.println(SAD_FACE + " OOPS!!! The time of an event cannot be empty." + System.lineSeparator());
            } else {
                tasks.add(new Event(split[0].toLowerCase().replace("event", ""), split[1].toLowerCase().replace("at", "")));
                Ui.printTaskAdded(tasks);
                Ui.printNumberOfTasks(tasks);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(SAD_FACE + " OOPS!!! Wrong format entered for event task.");
            System.out.println("Format: event <task name> /at <time>" + System.lineSeparator());
        }
    }

    /**
     * Allows users to search for a task in the task list by a keyword.
     * Keyword is case insensitive.
     *
     * @param tasks task list
     * @param str input entered by user
     */
    public static void findTasks(ArrayList<Task> tasks, String str) {
        ArrayList<Task> foundList = new ArrayList<>();
        ArrayList<Integer> counter = new ArrayList<>();

        if (str.toLowerCase().replace("find", "").trim().equals("")) {
            System.out.println(SAD_FACE + " OOPS!!! Missing search keyword." + System.lineSeparator());
        } else {
            String key = str.toLowerCase().trim().replace("find", "");
            int count = 0;
            for(int i = 0; i < tasks.size(); i++) {
                count++;
                String description = tasks.get(i).getDisplayString().toLowerCase();
                if (description.contains(key.trim())) {
                    foundList.add(tasks.get(i));
                    counter.add(count);
                }
            }
            Ui.printFoundList(foundList, counter);
        }
    }

}
