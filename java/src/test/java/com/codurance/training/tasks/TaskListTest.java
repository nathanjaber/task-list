package com.codurance.training.tasks;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    void addTask() {
        TaskList taskList = new TaskList();
        ProjectName projectName = new ProjectName("Project test");
        Task task = new Task(new TaskId(1), new TaskDescription("Task test"), false);

        taskList.addTask(projectName, task);
        List<Task> tasks = taskList.get(new ProjectName("Project test"));
        assertEquals(1, tasks.size());
    }
}