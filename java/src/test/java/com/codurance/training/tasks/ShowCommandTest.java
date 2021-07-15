package com.codurance.training.tasks;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import static org.mockito.Mockito.*;

class ShowCommandTest {
    private Faker faker;
    private ShowCommand showCommand;
    private TaskList tasks;
    private PrintWriter out;
    private PrintStream ps;
    private Console fakeConsole;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.faker = new Faker();

        tasks = mock(TaskList.class);
        out = mock(PrintWriter.class);
        fakeConsole = mock(Console.class);

        Task task = mock(Task.class);
        ps = mock(PrintStream.class);
    }

    @Test
    void execute() throws UnsupportedEncodingException {
        String projectName = "Test fixture";
        String taskText = "Run tasks";

        TaskList tasks = new TaskList();
        ShowCommand showCommand = new ShowCommand(fakeConsole, tasks);
        Task task = new Task(new TaskId(1), new TaskDescription(taskText), false);
        tasks.addTask(new ProjectName(projectName), task);

        showCommand.execute();

        verify(fakeConsole, times(1)).print(any(ProjectName.class));
        verify(fakeConsole, times(1)).print(any(DisplayMessage.class));

    }
}