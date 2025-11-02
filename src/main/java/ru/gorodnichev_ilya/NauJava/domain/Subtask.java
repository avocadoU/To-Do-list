package ru.gorodnichev_ilya.NauJava.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "subtask")
public class Subtask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subtaskID;

    private String subtaskName;

    private String subtaskDesc;

    private Integer position;

    private LocalDateTime dueDate;


    private boolean isCompleted;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public Subtask() {}

    public Subtask(String subtaskName, Task task) {
        this.subtaskName = subtaskName;
        this.task = task;
        this.isCompleted = false;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Long getSubtaskID() {
        return subtaskID;
    }

    public void setSubtaskID(Long subtaskID) {
        this.subtaskID = subtaskID;
    }

    public String getSubtaskName() {
        return subtaskName;
    }

    public void setSubtaskName(String subtaskName) {
        this.subtaskName = subtaskName;
    }

    public String getSubtaskDesc() {
        return subtaskDesc;
    }

    public void setSubtaskDesc(String subtaskDesc) {
        this.subtaskDesc = subtaskDesc;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
