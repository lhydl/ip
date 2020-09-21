package Duke;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Text UI of the program.
 */
public class Ui {

    private static final Scanner in = new Scanner(System.in);

    /**
     * Read input entered by the user.
     *
     * @return input entered by the user
     */
    public static String readCommand() {
        return in.nextLine();
    }

    /**
     * Print the exit line when user entered "bye".
     */
    public static void printExitScreen() {
        System.out.println("Bye. Hope to see you again soon!\n");
    }

    /**
     * Print the invalid command line.
     */
    public static void printInvalidCommand() {
        System.out.println("\u2639 " + "OOPS!!! I'm sorry, but I don't know what that means :-(" + System.lineSeparator());
    }

    /**
     * Print the missing task number line when the parser expects user to input a task number
     * but the user never input.
     */
    public static void printMissingTaskNumber() {
        System.out.println("\u2639 " + "OOPS!!! Missing task number." + System.lineSeparator());
    }

    /**
     * Print the number of tasks stored in the task list.
     *
     * @param tasks
     */
    public static void printNumberOfTasks(ArrayList<Task> tasks) {
        if (tasks.size() > 1) {
            System.out.println("Now you have " + tasks.size() + " tasks in the list" + System.lineSeparator());
        } else if (tasks.size() == 1) {
            System.out.println("Now you have 1 task in the list" + System.lineSeparator());
        } else {
            System.out.println("You currently have no task :-)" + System.lineSeparator());
        }
    }

    /**
     * Print the task added line when the user added a task to the task list.
     *
     * @param tasks
     */
    public static void printTaskAdded(ArrayList<Task> tasks) {
        System.out.println("Got it. I've added this task:");
        System.out.println(tasks.get(tasks.size() - 1));
    }

    /**
     * Print out the task list.
     *
     * @param tasks
     */
    public static void printList(ArrayList<Task> tasks) {
        if (tasks.size() == 0) {
            System.out.println("The current tasks list is empty");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 1; i <= tasks.size(); i++) {
                System.out.println(i + ". " + tasks.get(i - 1));
            }
        }
        System.out.println(); //added a new line after the list
    }

    public static void printFoundList(ArrayList<Task> foundList, ArrayList<Integer> counter) {
        if (foundList.size() > 0) {
            if (foundList.size() == 1) {
                System.out.println("There are " + foundList.size() + " matching task in your list:");
            } else {
                System.out.println("There are " + foundList.size() + " matching tasks in your list:");
            }
            for (int i = 0; i < foundList.size(); i++) {
                System.out.println(counter.get(i) + ". " + foundList.get(i));
            }
            System.out.println();
        } else {
            System.out.println("OOPS!!! No matching tasks found." + System.lineSeparator());
        }
    }

    /**
     * Print the welcome screen shown when the program starts.
     */
    public static void printWelcomeScreen() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?\n");
    }

}
