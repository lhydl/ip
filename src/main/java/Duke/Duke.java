package Duke;

import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        printWelcomeScreen();

        Scanner in = new Scanner(System.in);
        Task[] tasks = new Task[100];

        int count = 0;

        for (int i = 0; i < tasks.length; i++) {
            String str = in.nextLine();
            String[] spl = str.trim().split(" "); //split the command from the rest of the string
            if (str.trim().startsWith("todo") && spl[0].equals("todo")) {
                count = addTodo(tasks, count, str);
            } else if (str.trim().startsWith("deadline") && spl[0].equals("deadline") ) {
                count = addDeadline(tasks, count, str);
            } else if (str.trim().startsWith("event") && spl[0].equals("event")) {
                count = addEvent(tasks, count, str);
            } else if (str.trim().startsWith("list") && spl[0].equals("list")) {
                printList(tasks, count);
            } else if (str.trim().startsWith("done") && spl[0].equals("done")) {
                setDone(tasks, str);
            } else if (str.trim().startsWith("bye") && spl[0].equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!\n");
                break;
            } else {
                System.out.println("\u2639 " + "OOPS!!! I'm sorry, but I don't know what that means :-(" + System.lineSeparator());
            }
        }
    }


    public static void printList(Task[] tasks, int count) {
        if (tasks[0] == null) {
            System.out.println("List is empty.");
        } else {
            System.out.println("Here are the tasks in your list:");
        }

        for (int j = 1; j <= count; j++) {
            System.out.println(j + ". " + tasks[j - 1]);
        }
        System.out.println(); //added a new line after the list
    }

    public static void setDone(Task[] tasks, String str) {
        try {
            String digit = str.replaceAll("[^0-9]", ""); //extract digit from a string
            int num = Integer.parseInt(digit); //change string to int
            tasks[num - 1].setAsDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println("[" + tasks[num - 1].getStatusIcon() + "] " + tasks[num - 1].getDisplayString().trim() + System.lineSeparator());
        } catch (Exception e) {
            System.out.println("Invalid command" + System.lineSeparator());
        }
    }

    public static int addTodo(Task[] tasks, int count, String str) {
        if (str.replace("todo", "").trim().equals("")) {
            System.out.println("\u2639 " + "OOPS!!! The description of a todo cannot be empty." + System.lineSeparator());
        } else {
            tasks[count] = new Todo(str.replace("todo", ""));
            System.out.println("Got it. I've added this task:");
            System.out.println(tasks[count]);
            count++;
            if (count > 1) {
                System.out.println("Now you have " + count + " tasks in the list" + System.lineSeparator());
            } else {
                System.out.println("Now you have " + count + " task in the list" + System.lineSeparator());
            }
        }
        return count;
    }

    public static int addDeadline(Task[] tasks, int count, String str) {
        String[] split = str.split("/"); //split string into two parts by
        try {
            if (split[0].replace("deadline", "").trim().equals("")) {
                System.out.println("\u2639 " + "OOPS!!! The description of a deadline task cannot be empty." + System.lineSeparator());
            } else if (split[1].replace("by", "").trim().equals("")) {
                System.out.println("\u2639 " + "OOPS!!! The deadline (by) of a deadline task cannot be empty." + System.lineSeparator());
            } else {
                tasks[count] = new Deadline(split[0].replace("deadline", ""), split[1].replace("by", ""));
                System.out.println("Got it. I've added this task:");
                System.out.println(tasks[count]);
                count++;
                System.out.println("Now you have " + count + " tasks in the list" + System.lineSeparator());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u2639 " + "OOPS!!! The description/deadline of a deadline task cannot be empty." + System.lineSeparator());
        }
        return count;
    }

    public static int addEvent(Task[] tasks, int count, String str) {
        String[] split = str.split("/"); //split string into two parts by
        try {
            if (split[0].replace("event", "").trim().equals("")) {
                System.out.println("\u2639 " + "OOPS!!! The description of a an event cannot be empty." + System.lineSeparator());
            } else if (split[1].replace("at", "").trim().equals("")) {
                System.out.println("\u2639 " + "OOPS!!! The timing of a an event cannot be empty." + System.lineSeparator());
            } else {
                tasks[count] = new Event(split[0].replace("event", ""), split[1].replace("at", ""));
                System.out.println("Got it. I've added this task:");
                System.out.println(tasks[count]);
                count++;
                System.out.println("Now you have " + count + " tasks in the list" + System.lineSeparator());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u2639 " + "OOPS!!! The description/timing of an event cannot be empty." + System.lineSeparator());
        }
        return count;
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
