package com.codurance.training.tasks;

public class TaskDescription {
    private String value;

    public TaskDescription(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        TaskDescription anotherTaskDescription = (TaskDescription) obj;
        return anotherTaskDescription.value.equals(this.value);
    }
}
