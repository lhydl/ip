import java.util.Arrays;
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

        String[] arr = new String[100];
        Scanner in = new Scanner(System.in);

        int count = 0;
        int i, j;

        for(i=0; i<arr.length; i++){
            String s = in.nextLine();
            if(!s.equals("list") && !s.equals("bye")) {
                arr[i] = s;
                System.out.println("Added: " + arr[i] + "\n");
                count++;
            }
            else if(s.equals("list")){
                i--;
                for(j=1; j<=count; j++) {
                    System.out.println(j + ". " + arr[j-1] );
                }
                System.out.println(); //added a new line after the list
            }
            else {
                break;
            }
        }

        System.out.println("Bye. Hope to see you again soon!\n");
    }
}
