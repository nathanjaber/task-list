package com.codurance.training.tasks;

import java.util.List;
import java.util.Map;

public class ShowCommand extends Command {
    private Console console;
    private TaskList tasks;

    public ShowCommand(Console console, TaskList tasks) {
        super(CommandAction.SHOW);
        this.console = console;
        this.tasks = tasks;
    }

    @Override
    public void execute() {

        for (Map.Entry<ProjectName, List<Task>> project : tasks.entrySet()) {
            console.print(project.getKey());
            for (Task task : project.getValue()) {
                console.print(task.getDisplayMessage());
            }
            console.print();
        }
    }
}
