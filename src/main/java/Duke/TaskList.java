package Duke;

import java.util.ArrayList;

public class TaskList {

    public static final ArrayList<Task> tasks = new ArrayList<>();


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

}
