package ru.gorodnichev_ilya.NauJava.controller.REST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gorodnichev_ilya.NauJava.domain.Task;
import ru.gorodnichev_ilya.NauJava.repository.TaskRepository;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class TaskRestController {


    private final TaskRepository taskRepository;

    @Autowired
    public TaskRestController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/by-user/{userId}")
    public List<Task> getByUserId(@PathVariable Long userId) {
        return taskRepository.findByUserId(userId);
    }

    @GetMapping("/by-category/{userId}")
    public List<Task> getByCategoryName(@PathVariable String name) {
        return taskRepository.findByCategoryName(name);
    }

    @GetMapping("/criteria/by-user/{userId}")
    public List<Task> getByUserIdCriteria(@PathVariable Long userId) {
        return taskRepository.findByUserIdCriteria(userId);
    }

    @GetMapping("/criteria/by-category{name}")
    public List<Task> getByCategoryNameCriteria(@PathVariable String name) {
        return taskRepository.findByCategoryNameCriteria(name);
    }
}
