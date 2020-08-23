import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?\n");

        Scanner in = new Scanner(System.in);
        Task[] tasks = new Task[100];

        int count = 0;
        int i, j;

        for(i=0; i<tasks.length; i++) {
            String str = in.nextLine();
            if(!str.equals("list") && !str.equals("bye") && !str.contains("done")) {
                tasks[count] = new Task(str);
                System.out.println("Added: " + tasks[i].getDisplayString() + "\n");
                count++;
            }
            else if(str.equals("list")) {
                i--;
                System.out.println("Here are the tasks in your list:");
                for(j=1; j<=count; j++) {
                    System.out.println(j + ". " + "[" + tasks[j-1].getStatusIcon() + "] " + tasks[j-1].getDisplayString() );
                }
                System.out.println(); //added a new line after the list
            }
            else if(str.contains("done")) {
                String digit = str.replaceAll("[^0-9]", ""); //extract digit from a string
                int num = Integer.parseInt(digit); //change string to int
                tasks[num-1].setAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("[" + tasks[num-1].getStatusIcon() + "] " + tasks[num-1].getDisplayString() + "\n" );
            }
            else {
                break;
            }
        }

        System.out.println("Bye. Hope to see you again soon!\n");
    }
}
