package com.codurance.training.tasks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    @DisplayName("getDisplayMessage should not display deadline")
    void getDisplayMessageCase1() {
        Task task = new Task(
                new TaskId(1),
                new TaskDescription("fake task"),
                false);

        assertEquals("    [ ] 1: fake task", task.getDisplayMessage().toString());
    }

    @Test
    @DisplayName("getDisplayMessage should display deadline")
    void getDisplayMessageCase2() {
        Task task = new Task(
                new TaskId(1),
                new TaskDescription("fake task"),
                false,
                new DeadLine(LocalDate.parse("2020-03-26")));

        assertEquals("    [ ] 1: fake task; 2020-03-26", task.getDisplayMessage().toString());
    }
}