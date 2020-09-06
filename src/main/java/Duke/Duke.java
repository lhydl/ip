package Duke;

import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        printWelcomeScreen();

        Scanner in = new Scanner(System.in);
        Task[] tasks = new Task[100];

        int count = 0;
        int i;

        for(i=0; i<tasks.length; i++) {
            String str = in.nextLine();
            if (!str.trim().equals("list") && !str.trim().equals("bye") && !str.contains("done")) {
                if (str.contains("todo")) {
                    count = setTodo(tasks, count, str);
                } else if (str.contains("deadline")) {
                    count = setDeadline(tasks, count, str);
                } else if (str.contains("event")) {
                    count = setEvent(tasks, count, str);
                } else {
                    System.out.println("\u2639 " + "OOPS!!! I'm sorry, but I don't know what that means :-(" + System.lineSeparator());
                }
            } else if (str.trim().equals("list")) {
                printList(tasks, count);
            } else if (str.contains("done")) {
                setDone(tasks, str);
            } else {
                break;
            }
        }

        System.out.println("Bye. Hope to see you again soon!\n");
    }


    public static void setDone(Task[] tasks, String str) {
        try {
            String digit = str.replaceAll("[^0-9]", ""); //extract digit from a string
            int num = Integer.parseInt(digit); //change string to int
            tasks[num - 1].setAsDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println("[" + tasks[num - 1].getStatusIcon() + "]" + tasks[num - 1].getDisplayString().trim() + System.lineSeparator());
        } catch (Exception e) {
            System.out.println("Invalid command" + System.lineSeparator());
        }
    }

    public static void printList(Task[] tasks, int count) {
        int j;
        if (tasks[0] == null) {
            System.out.println("List is empty.");
        } else {
            System.out.println("Here are the tasks in your list:");
        }

        for (j=1; j<= count; j++) {
            System.out.println(j + ". " + tasks[j-1]);
        }
        System.out.println(); //added a new line after the list
    }

    public static int setEvent(Task[] tasks, int count, String str) {
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
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("\u2639 " + "OOPS!!! The description/timing of an event cannot be empty." + System.lineSeparator());
        }
        return count;
    }

    public static int setDeadline(Task[] tasks, int count, String str) {
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
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("\u2639 " + "OOPS!!! The description/deadline of a deadline task cannot be empty." + System.lineSeparator());
        }
        return count;
    }

    public static int setTodo(Task[] tasks, int count, String str) {
        if (str.replace("todo", "").trim().equals("")) {
            System.out.println("\u2639 " + "OOPS!!! The description of a todo cannot be empty." + System.lineSeparator());
        } else {
            tasks[count] = new Todo(str.replace("todo", ""));
            System.out.println("Got it. I've added this task:");
            System.out.println(tasks[count]);
            count++;
            System.out.println("Now you have " + count + " tasks in the list" + System.lineSeparator());
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
        System.out.println("Hello! I'm Duke.Duke");
        System.out.println("What can I do for you?\n");
    }
}
