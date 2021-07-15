package com.codurance.training.tasks;

public class CheckCommand extends Command {
    public CheckCommand(TaskId taskId) {
        super(CommandAction.CHECK, taskId);
    }

    @Override
    public void execute() {

    }
}
