import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Storage {
    private String path;

    public Storage(String path) {
        this.path = path;
    }

    public ArrayList<Task> load() throws Exception {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(path);

        if (!file.exists()) { // no file yet
            file.getParentFile().mkdir();
            file.createNewFile();
            return tasks;
        }

        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] split = line.split(" \\| ");

            String type = split[0];
            if (type == "T") {
                tasks.add(new ToDo(split[1]));
            } else if (type == "D") {
                tasks.add(new Deadline(split[1], split[2]));
            } else {
                tasks.add(new Event(split[2], split[3], split[1]));
            }
        }
        return tasks;
    }

    public void save(ArrayList<Task> tasks) {
        FileWriter writer = new FileWriter(this.path);
        for 
    }
}
