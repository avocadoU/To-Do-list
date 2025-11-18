package ru.gorodnichev_ilya.NauJava.service;

import ru.gorodnichev_ilya.NauJava.domain.Task;
import ru.gorodnichev_ilya.NauJava.domain.User;

import java.util.List;

public interface UserTaskTransactionalService {
    User createUserWithTasks(User user, List<Task> tasks);
}
