package smartstelle;

import java.io.IOException;

public class SmartStelle {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public SmartStelle(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (StelleException | IOException e) {
            System.out.println("Starting fresh (couldn't read save file).");
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.showWelcome();

        while (true) {
            String input = ui.readCommand();
            try {
                if (Parser.parse(input, tasks, storage, ui) == -1) {
                    break;
                }
            } catch (Exception e) {
                ui.showError(e.getMessage());
            }
        }

        ui.showGoodbye();
    }

    public static void main(String[] args) {
        new SmartStelle("data/tasks.txt").run();
    }
}
