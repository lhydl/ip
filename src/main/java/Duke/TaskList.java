package Duke;

import java.util.ArrayList;

/**
 * Contains the task list and operations to manipulate the tasks.
 */
public class TaskList {

    public static ArrayList<Task> tasks = new ArrayList<>();

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
            if (tasks.size() == 0) {
                Ui.printList(tasks);
            } else if (num <= tasks.size() && num != 0) {
                if (tasks.get(num - 1).getDoneStatus()) {
                    System.out.println("Task is already marked as done previously." + System.lineSeparator());
                } else {
                    tasks.get(num - 1).setAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(tasks.get(num - 1) + System.lineSeparator());
                }
            } else {
                Ui.printInvalidTaskNumber(tasks);
            }
        } catch (NumberFormatException e) {
            Ui.printWrongFormat("done");
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
            if (tasks.size() == 0) {
                Ui.printList(tasks);
            } else if (num <= tasks.size() && num != 0) {
                System.out.println("Noted. I've removed this task:");
                System.out.println(tasks.get(num - 1));
                tasks.remove(num - 1);
                Ui.printNumberOfTasks(tasks);
            } else {
                Ui.printInvalidTaskNumber(tasks);
            }
        } catch (NumberFormatException e) {
            Ui.printWrongFormat("delete");
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
            Ui.printWrongFormat("todo");
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
        String[] split = str.split("/by");
        try {
            if (split[0].toLowerCase().replace("deadline", "").trim().equals("")) {
                Ui.printWrongFormat("deadline");
            } else {
                tasks.add(new Deadline(split[0].toLowerCase().replace("deadline", ""), split[1].toLowerCase().replace("by", "")));
                Ui.printTaskAdded(tasks);
                Ui.printNumberOfTasks(tasks);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.printWrongFormat("deadline");
        }
    }

    /**
     * Adds a task type of Event to the task list.
     *
     * @param tasks task list
     * @param str input entered by user
     */
    public static void addEvent(ArrayList<Task> tasks, String str) {
        String[] split = str.split("/at");
        try {
            if (split[0].toLowerCase().replace("event", "").trim().equals("")) {
                Ui.printWrongFormat("event");
            } else {
                tasks.add(new Event(split[0].toLowerCase().replace("event", ""), split[1].toLowerCase().replace("at", "")));
                Ui.printTaskAdded(tasks);
                Ui.printNumberOfTasks(tasks);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.printWrongFormat("event");
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
            Ui.printWrongFormat("find");
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
