package com.codurance.training.tasks;

public class DisplayMessage {

    private final TaskId id;
    private final TaskDescription description;
    private final DeadLine deadLine;
    private final boolean done;

    public DisplayMessage(TaskId id, TaskDescription description, DeadLine deadLine, boolean done) {
        this.id = id;
        this.description = description;
        this.deadLine = deadLine;
        this.done = done;
    }

    @Override
    public String toString() {
        if(this.deadLine == null)
            return String.format("    [%c] %s: %s", (done ? 'x' : ' '), id, description);
        else
            return String.format("    [%c] %s: %s; %s", (done ? 'x' : ' '), id, description, deadLine);
    }
}
