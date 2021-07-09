package com.codurance.training.tasks;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ShowCommandTest {
    private Faker faker;
    private ShowCommand showCommand;
    private TaskMap tasks;
    private PrintWriter out;
    private PrintStream ps;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.faker = new Faker();

        tasks = mock(TaskMap.class);
        out = mock(PrintWriter.class);

        Task task = mock(Task.class);
        ps = mock(PrintStream.class);
    }

    @Test
    void execute() throws UnsupportedEncodingException {
        String projectName = "Test fixture";
        String taskText = "Run tasks";

        ShowCommand showCommand =  new ShowCommand();
        TaskMap tasks = new TaskMap();
        Task task = new Task(new TaskId(1), new TaskDescription(taskText), false);
        tasks.addTask(new ProjectName(projectName), task);

        List<String> lines = showCommand.execute(tasks);
        out.flush();

        assertEquals(lines.size(), 2);
        assertEquals(lines.get(0), projectName);
        assertEquals(lines.get(1), "    [ ] 1: " + taskText);

    }
}