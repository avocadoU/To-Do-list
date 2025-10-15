package ru.gorodnichev_ilya.NauJava.service;

import ru.gorodnichev_ilya.NauJava.domain.Task;

import java.util.Optional;

public interface TaskService {

    void createTask(Long id, String nameTask, Optional<String> descriptionTask);

    void updateNameTask(Long id, String nameTask);

    void updateDescriptionTask(Long id, String descriptionTask);

    Task findById(Long id);

    void deleteById(Long id);
}
