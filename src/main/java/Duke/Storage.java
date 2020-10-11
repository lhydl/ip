package Duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Deals with loading and saving of tasks into a file.
 */
public class Storage {

    /**
     * Saves data into a text file.
     *
     * @param tasks task list
     */
    public static void saveData(ArrayList<Task> tasks) {
        try {
            FileWriter fw = new FileWriter("savedData.txt");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tasks.size(); i++) {
                sb.append(tasks.get(i).saveDataFormat()).append(System.lineSeparator());
            }
            fw.write(sb.toString());
            fw.close();
        } catch (IOException e) {
            System.out.println("Output error.");
        }
    }

    /**
     * Loads data saved previously from the text file.
     *
     * @param tasks task list
     */
    public static void loadSavedData(ArrayList<Task> tasks) {
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
            System.out.println("Previously saved tasks loaded.");
            Ui.printList(tasks);
        } catch (FileNotFoundException e) {
            Ui.printNumberOfTasks(tasks);
        }
    }
}
