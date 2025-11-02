package ru.gorodnichev_ilya.NauJava.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "recurrence")
public class Recurrence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recurrenceID;

    @Enumerated(EnumType.STRING)
    private Pattern pattern;

    private boolean isActive;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "recurrence")
    private Task task;

    public Recurrence() {}

    public Recurrence(Pattern pattern, LocalDateTime startDate) {
        this.pattern = pattern;
        this.startDate = startDate;
        this.isActive = true;
        this.createdAt = LocalDateTime.now();
    }

    enum Pattern {
        DAILY,
        WEEKLY,
        MONTHLY,
        YEARLY
    }

    public Long getRecurrenceID() {
        return recurrenceID;
    }

    public void setRecurrenceID(Long recurrenceID) {
        this.recurrenceID = recurrenceID;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}

