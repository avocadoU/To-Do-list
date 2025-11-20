package ru.gorodnichev_ilya.NauJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gorodnichev_ilya.NauJava.domain.Task;
import ru.gorodnichev_ilya.NauJava.repository.TaskRepository;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/custom/tasks/view")
public class TaskControllerView {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskControllerView(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks")
    public String taskListView(Model model) {
        Iterable<Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);
        return "taskList";
    }
}
