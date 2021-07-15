package com.codurance.training.tasks;

public class AddProjectCommand extends Command {
    public AddProjectCommand(NodeType nodeType, ProjectName projectName) {
        super(CommandAction.ADD, nodeType, projectName);
    }

    @Override
    public void execute() {

    }
}
