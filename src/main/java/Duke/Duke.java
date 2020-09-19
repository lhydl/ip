package Duke;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Duke {

    private static final Scanner in = new Scanner(System.in);
    private static final ArrayList<Task> tasks = new ArrayList<Task>();


    public static void main(String[] args) {
        printWelcomeScreen();
        loadSavedData();
        run();
    }

    public static void run() {
        boolean isExit = false;
        while (!isExit) {
            String str = in.nextLine();
            Parser.parse(str, tasks);
            if(str.trim().startsWith("bye")) {
                isExit = true;
            }
        }
    }


    public static void printList(ArrayList<Task> tasks) {
        try {
            if (tasks.size() == 0){
                System.out.println("The current tasks list is empty");
            } else {
                System.out.println("Here are the tasks in your list:");
                for (int i = 1; i <= tasks.size(); i++) {
                    System.out.println(i + ". " + tasks.get(i - 1));
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The current tasks list is empty");
        }
        System.out.println(); //added a new line after the list
    }


    public static void setDone(ArrayList<Task> tasks, String str) {
        try {
            String digit = str.replaceAll("[^0-9]", ""); //extract digit from a string
            int num = Integer.parseInt(digit); //change string to int
            tasks.get(num - 1).setAsDone();
            System.out.println("Nice! I've marked this task as done:");
            System.out.println("[" + tasks.get(num - 1).getStatusIcon() + "] " + tasks.get(num - 1).getDisplayString().trim() + System.lineSeparator());
        } catch (Exception e) {
            System.out.println("Invalid command" + System.lineSeparator());
        }
    }


    public static void deleteTasks(ArrayList<Task> tasks, String str) {
        try {
            String digit = str.replaceAll("[^0-9]", ""); //extract digit from a string
            int num = Integer.parseInt(digit); //change string to int
            if (num <= tasks.size() && num != 0) {
                System.out.println("Noted. I've removed this task:");
                System.out.println(tasks.get(num - 1));
                tasks.remove(num-1);
                if (tasks.size() > 1) {
                    System.out.println("Now you have " + tasks.size() + " tasks in the list" + System.lineSeparator());
                } else {
                    System.out.println("Now you have " + tasks.size() + " task in the list" + System.lineSeparator());
                }
            } else {
                System.out.println("Invalid tasks number." + System.lineSeparator());
            }
        } catch (Exception e) {
            System.out.println("Invalid command" + System.lineSeparator());
        }
    }


    public static void addTodo(ArrayList<Task> tasks, String str) {
        if (str.replace("todo", "").trim().equals("")) {
            System.out.println("\u2639 " + "OOPS!!! The description of a todo cannot be empty." + System.lineSeparator());
        } else {
            tasks.add(new Todo(str.replace("todo", "")));
            System.out.println("Got it. I've added this task:");
            System.out.println(tasks.get(tasks.size()-1));
            if (tasks.size() > 1) {
                System.out.println("Now you have " + tasks.size() + " tasks in the list" + System.lineSeparator());
            } else {
                System.out.println("Now you have " + tasks.size() + " task in the list" + System.lineSeparator());
            }
        }
    }


    public static void addDeadline(ArrayList<Task> tasks, String str) {
        String[] split = str.split("/"); //split string into two parts by
        try {
            if (split[0].replace("deadline", "").trim().equals("")) {
                System.out.println("\u2639 " + "OOPS!!! The description of a deadline task cannot be empty." + System.lineSeparator());
            } else if (split[1].replace("by", "").trim().equals("")) {
                System.out.println("\u2639 " + "OOPS!!! The deadline (by) of a deadline task cannot be empty." + System.lineSeparator());
            } else {
                tasks.add(new Deadline(split[0].replace("deadline", ""), split[1].replace("by", "")));
                System.out.println("Got it. I've added this task:");
                System.out.println(tasks.get(tasks.size()-1));
                System.out.println("Now you have " + tasks.size() + " tasks in the list" + System.lineSeparator());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u2639 " + "OOPS!!! The description/deadline of a deadline task cannot be empty." + System.lineSeparator());
        }
    }


    public static void addEvent(ArrayList<Task> tasks, String str) {
        String[] split = str.split("/"); //split string into two parts by
        try {
            if (split[0].replace("event", "").trim().equals("")) {
                System.out.println("\u2639 " + "OOPS!!! The description of a an event cannot be empty." + System.lineSeparator());
            } else if (split[1].replace("at", "").trim().equals("")) {
                System.out.println("\u2639 " + "OOPS!!! The timing of a an event cannot be empty." + System.lineSeparator());
            } else {
                tasks.add(new Event(split[0].replace("event", ""), split[1].replace("at", "")));
                System.out.println("Got it. I've added this task:");
                System.out.println(tasks.get(tasks.size()-1));
                System.out.println("Now you have " + tasks.size() + " tasks in the list" + System.lineSeparator());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\u2639 " + "OOPS!!! The description/timing of an event cannot be empty." + System.lineSeparator());
        }
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


    public static void saveData() {
        try {
            FileWriter fw = new FileWriter("savedData.txt");
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<tasks.size(); i++) {
                sb.append(tasks.get(i).saveDataFormat()).append(System.lineSeparator());
            }
            fw.write(sb.toString());
            fw.close();
        } catch (IOException ignored) {
        }
    }


    public static void loadSavedData() {
        File saved = new File("savedData.txt");
        try {
            Scanner sc = new Scanner(saved);
            while (sc.hasNext()) {
                String str = sc.nextLine();
                String[] spl = str.split(" \\| ");
                Task t;

                switch (spl[0]) {
                case "T":
                    t = new Todo(spl[2]);
                    break;
                case "D":
                    t = new Deadline(spl[2], spl[3]);
                    break;
                default :
                    t = new Event(spl[2], spl[3]);
                    break;
                }

                if (spl[1].equals("1")) {
                    t.setAsDone();
                }
                tasks.add(t);
            }
            if (tasks.size() > 0) {
                System.out.println("You currently have " + tasks.size() + " outstanding tasks." + System.lineSeparator());
            } else {
                System.out.println("You currently have no task :-)" + System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            System.out.println("You currently have no task :-)" + System.lineSeparator());
        }
    }

}
