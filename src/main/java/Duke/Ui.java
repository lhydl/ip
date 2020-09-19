package Duke;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {

    private static final Scanner in = new Scanner(System.in);

    public static String readCommand() {
        return in.nextLine();
    }

    public static void printExitScreen() {
        System.out.println("Bye. Hope to see you again soon!\n");
    }

    public static void printInvalidCommand() {
        System.out.println("\u2639 " + "OOPS!!! I'm sorry, but I don't know what that means :-(" + System.lineSeparator());
    }

    public static void printMissingTaskNumber() {
        System.out.println("\u2639 " + "OOPS!!! Missing task number." + System.lineSeparator());
    }

    public static void printNumberOfTasks(ArrayList<Task> tasks) {
        if (tasks.size() > 1) {
            System.out.println("Now you have " + tasks.size() + " tasks in the list" + System.lineSeparator());
        } else if (tasks.size() == 1) {
            System.out.println("Now you have 1 task in the list" + System.lineSeparator());
        } else {
            System.out.println("You currently have no task :-)" + System.lineSeparator());
        }
    }

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
