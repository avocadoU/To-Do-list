package ru.gorodnichev_ilya.NauJava.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gorodnichev_ilya.NauJava.domain.Task;
import ru.gorodnichev_ilya.NauJava.domain.User;
import ru.gorodnichev_ilya.NauJava.repository.TaskRepository;
import ru.gorodnichev_ilya.NauJava.repository.UserRepository;

import java.util.List;

@Service
public class UserTaskTransactionalServiceImpl implements UserTaskTransactionalService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    @Autowired
    public UserTaskTransactionalServiceImpl(UserRepository userRepository,
                                            TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    @Transactional
    public User createUserWithTasks(User user, List<Task> tasks) {

        User savedUser = userRepository.save(user);

        for (Task task : tasks) {
            task.setUser(savedUser);
            taskRepository.save(task);
        }

        return savedUser;
    }
}
