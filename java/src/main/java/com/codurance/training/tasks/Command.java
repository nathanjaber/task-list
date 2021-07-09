package com.codurance.training.tasks;

public class Command {
    private CommandAction commandAction;
    private NodeType nodeType;
    private ProjectName projectName;
    private TaskDescription taskDescription;
    private TaskId taskId;
    private DeadLine deadLine;

    public Command(CommandAction commandAction, NodeType nodeType, ProjectName projectName) {
        this.commandAction = commandAction;
        this.nodeType = nodeType;
        this.projectName = projectName;
    }

    public Command(CommandAction commandAction, NodeType nodeType, ProjectName projectName, TaskDescription taskDescription) {
        this.commandAction = commandAction;
        this.nodeType = nodeType;
        this.projectName = projectName;
        this.taskDescription = taskDescription;
    }

    public Command(CommandAction commandAction) {
        this.commandAction = commandAction;
    }

    public Command(CommandAction commandAction, TaskId taskId) {
        this.commandAction = commandAction;
        this.taskId = taskId;
    }

    public Command(CommandAction commandAction, TaskId taskId, DeadLine deadLine) {
        this.commandAction = commandAction;
        this.taskId = taskId;
        this.deadLine = deadLine;
    }

    public CommandAction getCommandAction() {
        return commandAction;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public ProjectName getProjectName() {
        return projectName;
    }

    public TaskDescription getTaskDescription() {
        return taskDescription;
    }

    public TaskId getTaskId() {
        return taskId;
    }

    public DeadLine getTaskDate() {
        return deadLine;
    }

    public DeadLine getDeadLine() {
        return deadLine;
    }
}
