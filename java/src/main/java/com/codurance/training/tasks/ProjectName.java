package com.codurance.training.tasks;

public class ProjectName {
    private String value;

    public ProjectName(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        ProjectName anotherProject = (ProjectName)obj;
        return this.value.equals(anotherProject.value);
    }
}
