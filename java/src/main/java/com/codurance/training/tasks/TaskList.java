package com.codurance.training.tasks;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class TaskList extends LinkedHashMap<ProjectName, List<Task>> {
    public void addTask(ProjectName projectName, Task task) {
        List<Task> tasks = getTasksByProjectName(projectName);
        tasks.add(task);
    }

    private List<Task> getTasksByProjectName(ProjectName projectName) {
        if(this.containsKey(projectName))
            return this.get(projectName);

        ArrayList<Task> result = new ArrayList<>();
        this.put(projectName, result);
        return result;
    }
}
