package com.codurance.training.tasks;

public class Task {
    private final TaskId id;
    private final TaskDescription description;
    private boolean done;
    private DeadLine deadLine;

    public Task(TaskId id, TaskDescription description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    public Task(TaskId id, TaskDescription description, boolean done, DeadLine deadLine) {
        this.id = id;
        this.description = description;
        this.done = done;
        this.deadLine = deadLine;
    }

    public TaskId getId() {
        return this.id;
    }

    public TaskDescription getDescription() {
        return this.description;
    }



    public boolean isDone() {
        return this.done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public DisplayMessage getDisplayMessage() {
        return new DisplayMessage(getId(), getDescription(), getDeadLine(), isDone());
    }

    public DeadLine getDeadLine() {
        return this.deadLine;
    }

    public void setDeadLine(DeadLine deadLine) {
        this.deadLine = deadLine;
    }
}
