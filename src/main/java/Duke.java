import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        printWelcomeScreen();

        Scanner in = new Scanner(System.in);
        Task[] tasks = new Task[100];

        int count = 0;
        int i, j;

        for(i=0; i<tasks.length; i++) {
            String str = in.nextLine();
            if(!str.equals("list") && !str.equals("bye") && !str.contains("done")) {
                if(str.contains("todo")) {
                    tasks[count] = new Todo(str.replace("todo", ""));
                    System.out.println("Got it. I've added this task: ");
                    System.out.println(tasks[count]);
                    count++;
                    System.out.println("Now you have " + count + " tasks in the list" + System.lineSeparator());
                }
                else if(str.contains("deadline")) {
                    String[] split = str.split("/"); //split string into two parts by
                    tasks[count] = new Deadline(split[0].replace("deadline", ""), split[1].replace("by", ""));
                    System.out.println("Got it. I've added this task: ");
                    System.out.println(tasks[count]);
                    count++;
                    System.out.println("Now you have " + count + " tasks in the list" + System.lineSeparator());
                }
                else if(str.contains("event")) {
                    String[] split = str.split("/"); //split string into two parts by
                    tasks[count] = new Event(split[0].replace("event", ""), split[1].replace("at", ""));
                    System.out.println("Got it. I've added this task: ");
                    System.out.println(tasks[count]);
                    count++;
                    System.out.println("Now you have " + count + " tasks in the list" + System.lineSeparator());
                }
                else {
                    System.out.println("Invalid command." + System.lineSeparator());
                }
            }
            else if(str.equals("list")) {
                i--;
                if(tasks[0] == null) {
                    System.out.println("List is empty.");
                }
                else {
                    System.out.println("Here are the tasks in your list:");
                }
                for(j=1; j<=count; j++) {
                    System.out.println(j + ". " + tasks[j-1]);
                }
                System.out.println(); //added a new line after the list
            }
            else if(str.contains("done")) {
                try {
                    String digit = str.replaceAll("[^0-9]", ""); //extract digit from a string
                    int num = Integer.parseInt(digit); //change string to int
                    tasks[num - 1].setAsDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("[" + tasks[num - 1].getStatusIcon() + "] " + tasks[num - 1].getDisplayString() + "\n");
                }
                catch (Exception e) {
                    System.out.println("Invalid command" + System.lineSeparator());
                }
            }
            else {
                break;
            }
        }

        System.out.println("Bye. Hope to see you again soon!\n");
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
