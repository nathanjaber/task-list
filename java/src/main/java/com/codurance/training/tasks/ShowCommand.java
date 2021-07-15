package com.codurance.training.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShowCommand extends Command {
    public ShowCommand () {
        super(CommandAction.SHOW);
    }

    public List<String> execute(TaskList tasks) {
        List<String> lines = new ArrayList<>();

        for (Map.Entry<ProjectName, List<Task>> project : tasks.entrySet()) {
            lines.add(project.getKey().toString());
            for (Task task : project.getValue()) {
                lines.add(task.getDisplayMessage().toString());
            }
        }
        return lines;
    }
}
