package ru.gorodnichev_ilya.NauJava.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ru.gorodnichev_ilya.NauJava.domain.Task;

public class TaskRepository implements CrudRepository<Task, Long> {
    private final List<Task> taskContainer;

    @Autowired
    public TaskRepository(List<Task> taskContainer) {
        this.taskContainer = taskContainer;
    }

    @Override
    public void create(Task task) {
        // логика
    }

    @Override
    public Task read(Long id) {
        // логика
    }

    @Override
    public void update(Task task) {
        // логика
    }

    @Override
    public void delete(Long id) {
        // логика
    }
}
