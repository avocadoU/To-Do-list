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
        newTask.setTaskName(nameTask);
        newTask.setTaskDesc(descriptionTask.orElse(null));
        taskRepository.save(newTask);
    }

    @Override
    public void updateNameTask(Long id, String nameTask) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found: " + id));

        task.setTaskName(nameTask);
        taskRepository.save(task);
    }

    @Override
    public void updateDescriptionTask(Long id, String descriptionTask) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found: " + id));

        task.setTaskDesc(descriptionTask);
        taskRepository.save(task);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
