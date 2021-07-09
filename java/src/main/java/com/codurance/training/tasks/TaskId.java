package com.codurance.training.tasks;

public class TaskId {
    private Integer id;

    public TaskId(Integer id) {
        this.id = id;
    }

    public Integer toInteger() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        TaskId anotherTaskId = (TaskId)obj;
        return this.id.equals(anotherTaskId.id);
    }

    public TaskId nextId() {
        return new TaskId(++id);
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
