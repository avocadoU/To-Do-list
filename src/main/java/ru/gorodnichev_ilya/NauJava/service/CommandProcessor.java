package ru.gorodnichev_ilya.NauJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gorodnichev_ilya.NauJava.service.TaskService;

import java.util.Optional;

@Component
public class CommandProcessor {
    private final TaskService taskService;

    @Autowired
    public CommandProcessor(TaskService taskService) {
        this.taskService = taskService;
    }

    public void processCommand(String input) {
        String[] cmd = input.split(" ");
        switch(cmd[0]) {
            case "create" -> {
                taskService.createTask(Long.valueOf(cmd[1]), cmd[2], Optional.of(cmd[3]));
                System.out.println("Задача успешно добавлена...");
            }
            case "updateNameTask" -> {
                taskService.updateNameTask(Long.valueOf(cmd[1]), cmd[2]);
                System.out.println("Имя задачи успешно изменено...");
            }
            case "updateDescTask" -> {
                taskService.updateDescriptionTask(Long.valueOf(cmd[1]), cmd[2]);
                System.out.println("Описание задачи успешно изменено");
            }
            case "findById" -> {
                System.out.println("Задача успешно найдена...");
                System.out.println(taskService.findById(Long.valueOf(cmd[1])));
            }
            case "deleteById" -> {
                taskService.deleteById(Long.valueOf(cmd[1]));
                System.out.println("Задача успешно удалена...");
            }
            default -> System.out.println("Введена неизвестная команда...");
        }
    }
}
