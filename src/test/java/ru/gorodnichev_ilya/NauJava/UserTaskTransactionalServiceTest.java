package ru.gorodnichev_ilya.NauJava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.gorodnichev_ilya.NauJava.domain.Task;
import ru.gorodnichev_ilya.NauJava.domain.User;
import ru.gorodnichev_ilya.NauJava.repository.TaskRepository;
import ru.gorodnichev_ilya.NauJava.repository.UserRepository;
import ru.gorodnichev_ilya.NauJava.service.UserTaskTransactionalService;

import java.util.List;
import java.util.UUID;

@SpringBootTest
@ActiveProfiles("test")
public class UserTaskTransactionalServiceTest {
    @Autowired
    private UserTaskTransactionalService service;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @BeforeEach
    void clean() {
        taskRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    void testCreateUserWithTasks_success() {
        User user = new User();
        user.setLogin(UUID.randomUUID().toString());
        user.setEmail(UUID.randomUUID().toString());

        Task task1 = new Task();
        task1.setTaskName(UUID.randomUUID().toString());

        Task task2 = new Task();
        task2.setTaskName(UUID.randomUUID().toString());

        List<Task> tasks = List.of(task1, task2);

        User savedUser = service.createUserWithTasks(user, tasks);

        Assertions.assertNotNull(savedUser.getUserID());

        List<Task> savedTasks = (List<Task>) taskRepository.findAll();
        Assertions.assertEquals(2, savedTasks.size());

        for (Task t : savedTasks) {
            Assertions.assertEquals(savedUser.getUserID(), t.getUser().getUserID());
        }
    }
}
