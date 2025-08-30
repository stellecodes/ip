import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Storage {
    private String path;

    public Storage(String path) {
        this.path = path;
    }

    public ArrayList<Task> load() throws IOException, StelleException {
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
            String completion = split[1];
            String taskName = split[2];
            boolean isCompleted = completion.equals("1");

            if (type.equals("T")) {
                tasks.add(new ToDo(taskName, isCompleted));
            } else if (type.equals("D")) {
                tasks.add(new Deadline(taskName, split[3], isCompleted));
            } else {
                tasks.add(new Event(split[3], split[4], taskName, isCompleted));
            }
        }
        sc.close();
        return tasks;
    }

    public void save(ArrayList<Task> tasks) throws IOException {
        FileWriter writer = new FileWriter(this.path);
        for (Task task : tasks) {
            writer.write(task.toSaveFormat() + System.lineSeparator());
        }

        writer.close();
    }
}
