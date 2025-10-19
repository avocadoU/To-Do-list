package ru.gorodnichev_ilya.NauJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gorodnichev_ilya.NauJava.repository.TaskRepository;
import ru.gorodnichev_ilya.NauJava.domain.Task;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void createTask(Long id, String nameTask, Optional<String> descriptionTask) {
        Task newTask = new Task();
        newTask.setId(id);
        newTask.setNameTask(nameTask);
        newTask.setDescriptionTask(descriptionTask.orElse(null));
        taskRepository.create(newTask);
    }

    @Override
    public void updateNameTask(Long id, String nameTask) {
        Task task = new Task();
        task.setId(id);
        task.setNameTask(nameTask);
        taskRepository.update(task);
    }

    @Override
    public void updateDescriptionTask(Long id, String descriptionTask) {
        Task task = new Task();
        task.setId(id);
        task.setDescriptionTask(descriptionTask);
        taskRepository.update(task);
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.read(id);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.delete(id);
    }
}
