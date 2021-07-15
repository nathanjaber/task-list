package com.codurance.training.tasks;

public class DeadLineCommand extends Command {
    public DeadLineCommand(TaskId taskId, DeadLine deadLine) {
        super(CommandAction.DEADLINE, taskId, deadLine);
    }

    @Override
    public void execute() {

    }
}
