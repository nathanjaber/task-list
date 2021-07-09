package com.codurance.training.tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class DeadLine {
    private LocalDate localDate;

    public DeadLine(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeadLine deadLine = (DeadLine) o;
        return Objects.equals(localDate, deadLine.localDate);
    }

    @Override
    public String toString() {
        return localDate.format(DateTimeFormatter.ISO_DATE);
    }
}
