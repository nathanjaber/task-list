package com.codurance.training.tasks;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.Month;

public class CommandLineTest extends TestCase {

    private Console console;
    private TaskList taskList;

    @BeforeEach
    public void setUp() {
        console = Mockito.mock(Console.class);
        taskList = Mockito.mock(TaskList.class);
    }
    @Test
    @DisplayName("getCommand should produce correct add project instance")
    public void testGetCommandCase1() {
        // pré condições
        String textLine = "add project training";
        CommandLine commandLine = new CommandLine(textLine);
        ProjectName expectedProjectName = new ProjectName("training");

        // ação
        Command command = commandLine.makeCommand(console, taskList);

        // pós condições
        assertEquals(CommandAction.ADD, command.getCommandAction());
        assertEquals(NodeType.PROJECT, command.getNodeType());
        assertEquals(expectedProjectName, command.getProjectName());
    }
    /* [CMD]  [nodetype]  [projectname]          [taskdescription]
     * add      task        training       Four Elements of Simple Design
     * */

    @Test
    @DisplayName("getCommand should produce correct add task instance")
    public void testGetCommandCase2() {
        // pré condições
        String textLine = "add task training Four Elements of Simple Design";
        CommandLine commandLine = new CommandLine(textLine);
        ProjectName expectedProjectName = new ProjectName("training");
        TaskDescription expectedTaskDescription = new TaskDescription("Four Elements of Simple Design");

        // ação
        Command command = commandLine.makeCommand(console, taskList);

        // pós condições
        assertEquals(CommandAction.ADD, command.getCommandAction());
        assertEquals(NodeType.TASK, command.getNodeType());
        assertEquals(expectedProjectName, command.getProjectName());
        assertEquals(expectedTaskDescription, command.getTaskDescription());
    }

    /*
     * [CMD]
     * "show"
     * expected:
        "secrets",
        "    [ ] 1: Eat more donuts.",
        "    [ ] 2: Destroy all humans.",
        ""
        );
     * */

    @Test
    @DisplayName("getCommand should produce correct show instance")
    public void testGetCommandCase3() {
        // pré condições
        String textLineShow = "show";
        CommandLine commandLine = new CommandLine(textLineShow);

        // ação
        Command command = commandLine.makeCommand(console, taskList);

        // pós condições
        assertEquals(CommandAction.SHOW, command.getCommandAction());
    }

    /*
     * [CMD]
     * "show"
     * expected:
        "secrets",
        "    [ ] 1: Eat more donuts.",
        "    [ ] 2: Destroy all humans.",
        ""
        );
     * */

    @Test
    @DisplayName("getCommand should produce correct check instance")
    public void testGetCommandCase4() {
        // pré condições
        String textLine = "check 1";
        CommandLine commandLine = new CommandLine(textLine);

        // ação
        Command command = commandLine.makeCommand(console, taskList);

        // pós condições
        assertEquals(CommandAction.CHECK, command.getCommandAction());
        assertEquals(new TaskId(1), command.getTaskId());
    }

    @Test
    @DisplayName("getCommand should produce correct uncheck instance")
    public void testGetCommandCase5() {
        // pré condições
        String textLine = "uncheck 2";
        CommandLine commandLine = new CommandLine(textLine);

        // ação
        Command command = commandLine.makeCommand(console, taskList);

        // pós condições
        assertEquals(CommandAction.UNCHECK, command.getCommandAction());
        assertEquals(new TaskId(2), command.getTaskId());
    }

    @Test
    @DisplayName("getCommand should produce correct help instance")
    public void testGetCommandCase6() {
        // pré condições
        String textLine = "help";
        CommandLine commandLine = new CommandLine(textLine);

        // ação
        Command command = commandLine.makeCommand(console, taskList);

        // pós condições
        assertEquals(CommandAction.HELP, command.getCommandAction());
    }

    @Test
    @DisplayName("getCommand should produce correct quit instance")
    public void testGetCommandCase7() {
        // pré condições
        String textLine = "quit";
        CommandLine commandLine = new CommandLine(textLine);

        // ação
        Command command = commandLine.makeCommand(console, taskList);

        // pós condições
        assertEquals(CommandAction.QUIT, command.getCommandAction());
    }

    @Test
    @DisplayName("getCommand should produce correct deadline instance")
    public void testGetCommandCase8() {
        // pré condições
        String textLine = "deadline 1 2021-03-06";
        CommandLine commandLine = new CommandLine(textLine);
        DeadLine expectedDeadLine = new DeadLine(LocalDate.of(2021, Month.MARCH, 6));

        // ação
        Command command = commandLine.makeCommand(console, taskList);

        // pós condições
        assertEquals(CommandAction.DEADLINE, command.getCommandAction());
        assertEquals(new TaskId(1), command.getTaskId());
        assertEquals(expectedDeadLine, command.getTaskDate());
    }

}