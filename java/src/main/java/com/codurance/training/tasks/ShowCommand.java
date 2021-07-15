package com.codurance.training.tasks;

import java.util.List;
import java.util.Map;

public class ShowCommand extends Command {
    private Console console;

    public ShowCommand(Console console) {
        super(CommandAction.SHOW);
        this.console = console;
    }

    public void execute(TaskList tasks) {

        for (Map.Entry<ProjectName, List<Task>> project : tasks.entrySet()) {
            console.print(project.getKey());
            for (Task task : project.getValue()) {
                console.print(task.getDisplayMessage());
            }
        }
    }
}
