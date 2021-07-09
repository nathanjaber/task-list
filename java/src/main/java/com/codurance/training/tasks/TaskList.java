package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class TaskList implements Runnable {
    private static final String QUIT = "quit";

    private final TaskMap tasks = new TaskMap();
    private final BufferedReader in;
    private final PrintWriter out;

    private TaskId lastId = new TaskId(0);

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskList(in, out).run();
    }

    public TaskList(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
    }

    public void run() {
        boolean shouldContinue = true;
        while (shouldContinue) {
            out.print("> ");
            out.flush();
            CommandLine commandLine;
            try {
                commandLine = new CommandLine(in.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            shouldContinue = execute(commandLine.getCommand());
        }
    }

    private boolean execute(Command command) {
        boolean shouldContinue = true;
        switch (command.getCommandAction()) {
            case SHOW:
                show();
                break;
            case ADD:
                add(command);
                break;
            case CHECK:
                check(command);
                break;
            case UNCHECK:
                uncheck(command);
                break;
            case HELP:
                help();
                break;
            case QUIT:
                shouldContinue = quit();
                break;
            case DEADLINE:
                deadline(command);
                break;
            default:
                break;
        }
        return shouldContinue;
    }

    private boolean quit() {
        return false;
    }

    private void show() {
        for (Map.Entry<ProjectName, List<Task>> project : tasks.entrySet()) {
            out.println(project.getKey());
            for (Task task : project.getValue()) {
                out.println(task.getDisplayMessage());
            }
            out.println();
        }
    }

    private void add(Command command) {
        if (command.getNodeType() == NodeType.PROJECT) {
            addProject(command.getProjectName());
        } else if (command.getNodeType() == NodeType.TASK) {
            addTask(command.getProjectName(), command.getTaskDescription(), command.getDeadLine());
        }
    }

    private void addProject(ProjectName projectName) {
        tasks.put(projectName, new ArrayList<Task>());
    }

    private void addTask(ProjectName projectName, TaskDescription taskDescription, DeadLine deadLine) {
        List<Task> projectTasks = tasks.get(projectName);
        if (projectTasks == null) {
            out.printf("Could not find a project with the name \"%s\".", projectName);
            out.println();
            return;
        }
        if(deadLine == null)
            projectTasks.add(new Task(lastId.nextId(), taskDescription, false));
        else
            projectTasks.add(new Task(lastId.nextId(), taskDescription, false, deadLine));
    }

    private void check(Command command) {
        setDone(command.getTaskId(), true);
    }

    private void uncheck(Command command) {
        setDone(command.getTaskId(), false);
    }

    private void deadline(Command command) {
        setDeadline(command.getTaskId(), command.getDeadLine());
    }

    private void setDeadline(TaskId taskId, DeadLine deadLine) {
        for (Map.Entry<ProjectName, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId().equals(taskId)) {
                    task.setDeadLine(deadLine);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", taskId.toInteger());
        out.println();
    }

    private void setDone(TaskId taskid, boolean done) {
        for (Map.Entry<ProjectName, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId().equals(taskid)) {
                    task.setDone(done);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", taskid.toInteger());
        out.println();
    }

    private void help() {
        out.println("Commands:");
        out.println("  show");
        out.println("  add project <project name>");
        out.println("  add task <project name> <task description> [task deadline]");
        out.println("  deadline <task ID>* <task deadline>");
        out.println("  check <task ID>");
        out.println("  uncheck <task ID>");
        out.println();
    }

    private void error(String command) {
        out.printf("I don't know what the command \"%s\" is.", command);
        out.println();
    }
}
