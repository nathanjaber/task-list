package com.codurance.training.tasks;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskMapTest {

    @Test
    void addTask() {
        TaskMap taskMap = new TaskMap();
        ProjectName projectName = new ProjectName("Project test");
        Task task = new Task(new TaskId(1), new TaskDescription("Task test"), false);

        taskMap.addTask(projectName, task);
        List<Task> taskList = taskMap.get(new ProjectName("Project test"));
        assertEquals(1, taskList.size());
    }
}