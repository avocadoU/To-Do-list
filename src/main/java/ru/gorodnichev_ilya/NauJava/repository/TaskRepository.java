package ru.gorodnichev_ilya.NauJava.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ru.gorodnichev_ilya.NauJava.domain.Task;

@Component
public class TaskRepository implements CrudRepository<Task, Long> {
    private final List<Task> taskContainer;

    @Autowired
    public TaskRepository(List<Task> taskContainer) {
        this.taskContainer = taskContainer;
    }

    @Override
    public void create(Task task) {
        taskContainer.add(task);
    }

    @Override
    public Task read(Long id) {
        return taskContainer.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Task task) {
        delete(task.getId());
        taskContainer.add(task);
    }

    @Override
    public void delete(Long id) {
        taskContainer.removeIf(task -> task.getId().equals(id));
    }
}
