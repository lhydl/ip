package Duke;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Text UI of the program.
 */
public class Ui {

    private static Scanner in = new Scanner(System.in);
    private static final String SMILEY_FACE = "\uD83D\uDE0A";
    private static final String SAD_FACE = "\u2639";

    /**
     * Reads input entered by the user.
     *
     * @return input entered by the user
     */
    public static String readCommand() {
        return in.nextLine();
    }

    /**
     * Prints the exit line when user entered "bye".
     */
    public static void printExitScreen() {
        System.out.println("All changes saved.");
        System.out.println("Bye. Hope to see you again soon!" + System.lineSeparator());
    }

    /**
     * Prints the invalid command line.
     */
    public static void printInvalidCommand() {
        System.out.println(SAD_FACE + " OOPS!!! I'm sorry, but I don't know what that means :-(" + System.lineSeparator());
    }

    /**
     * Prints invalid task number when task number entered does not exist.
     */
    public static void printInvalidTaskNumber(ArrayList<Task> tasks) {
        System.out.println("Invalid task number.");
        System.out.println("Enter a task number from 1 to " + tasks.size() + "." + System.lineSeparator());
    }

    /**
     * Prints the number of tasks stored in the task list.
     *
     * @param tasks task list
     */
    public static void printNumberOfTasks(ArrayList<Task> tasks) {
        if (tasks.size() > 1) {
            System.out.println("Now you have " + tasks.size() + " tasks in the list." + System.lineSeparator());
        } else if (tasks.size() == 1) {
            System.out.println("Now you have 1 task in the list." + System.lineSeparator());
        } else {
            System.out.println("You currently have no task :-)" + System.lineSeparator());
        }
    }

    /**
     * Prints the task added line when the user added a task to the task list.
     *
     * @param tasks task list
     */
    public static void printTaskAdded(ArrayList<Task> tasks) {
        System.out.println(SMILEY_FACE + " Got it. I've added this task:");
        System.out.println(tasks.get(tasks.size() - 1));
    }

    /**
     * Prints out the task list.
     *
     * @param tasks task list
     */
    public static void printList(ArrayList<Task> tasks) {
        if (tasks.size() == 0) {
            System.out.println("The current task list is empty.");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 1; i <= tasks.size(); i++) {
                System.out.println(i + ". " + tasks.get(i - 1));
            }
        }
        System.out.println(); //added a new line after the list
    }

    /**
     * Prints out tasks matching the searched keyword.
     *
     * @param foundList list of tasks with matching keywords
     * @param counter list of task numbers of tasks with matching keywords (corresponding to the position in task list)
     */
    public static void printFoundList(ArrayList<Task> foundList, ArrayList<Integer> counter) {
        if (foundList.size() > 0) {
            if (foundList.size() == 1) {
                System.out.println("There is 1 matching task in your list:");
            } else {
                System.out.println("There are " + foundList.size() + " matching tasks in your list:");
            }
            for (int i = 0; i < foundList.size(); i++) {
                System.out.println(counter.get(i) + ". " + foundList.get(i));
            }
            System.out.println();
        } else {
            System.out.println(SAD_FACE + " OOPS!!! No matching tasks found." + System.lineSeparator());
        }
    }

    /**
     * Prints wrong format line if the wrong format is entered.
     *
     * @param input string to determine if case is deadline or event
     */
    public static void printWrongFormat(String input) {
        switch (input) {
        case "todo":
            System.out.println(SAD_FACE + " OOPS!!! The task name of a todo task cannot be empty.");
            System.out.println("Format: todo <task name>" + System.lineSeparator());
            break;
        case "deadline":
            System.out.println(SAD_FACE + " OOPS!!! Wrong format entered for deadline task.");
            System.out.println("Format: deadline <task name> /by <time>" + System.lineSeparator());
            break;
        case "event":
            System.out.println(SAD_FACE + " OOPS!!! Wrong format entered for event task.");
            System.out.println("Format: event <task name> /at <time>" + System.lineSeparator());
            break;
        case "done":
            System.out.println(SAD_FACE + " OOPS!!! Missing task number.");
            System.out.println("Format: done <task number>" + System.lineSeparator());
            break;
        case "delete":
            System.out.println(SAD_FACE + " OOPS!!! Missing task number.");
            System.out.println("Format: delete <task number>" + System.lineSeparator());
            break;
        case "find":
            System.out.println(SAD_FACE + " OOPS!!! Missing search keyword.");
            System.out.println("Format: find <keyword>" + System.lineSeparator());
            break;
        }
    }

    /**
     * Prints the welcome screen when the program starts.
     */
    public static void printWelcomeScreen() {
        String logo = " ____        _\n"
                + "|  _ \\ _   _| | _____\n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println(logo);
        System.out.println("User guide available at: https://lhydl.github.io/ip/" + System.lineSeparator());
        System.out.println("Hello! I'm Duke! " + SMILEY_FACE + System.lineSeparator());
    }

    /**
     * Prints the prompt for user to enter a command.
     */
    public static void printPrompt() {
        System.out.println("What can I do for you?" + System.lineSeparator());
    }

}
