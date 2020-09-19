package Duke;

import java.util.Scanner;

public class Ui {

    private static final Scanner in = new Scanner(System.in);

    public static String readCommand() {
        return in.nextLine();
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
