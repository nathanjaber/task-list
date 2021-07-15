package com.codurance.training.tasks;

public class UncheckCommand extends Command {
    public UncheckCommand(TaskId taskId) {
        super(CommandAction.UNCHECK, taskId);
    }

    @Override
    public void execute() {

    }
}
