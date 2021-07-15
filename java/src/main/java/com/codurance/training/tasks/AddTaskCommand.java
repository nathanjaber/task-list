package com.codurance.training.tasks;

public class AddTaskCommand extends Command {
    public AddTaskCommand(NodeType nodeType, ProjectName projectName, TaskDescription taskDescription) {
        super(CommandAction.ADD, nodeType, projectName, taskDescription);
    }

    @Override
    public void execute() {

    }
}
