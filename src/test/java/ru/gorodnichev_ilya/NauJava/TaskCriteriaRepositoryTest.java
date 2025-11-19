package ru.gorodnichev_ilya.NauJava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.gorodnichev_ilya.NauJava.domain.Category;
import ru.gorodnichev_ilya.NauJava.domain.Task;
import ru.gorodnichev_ilya.NauJava.domain.User;
import ru.gorodnichev_ilya.NauJava.repository.CategoryRepository;
import ru.gorodnichev_ilya.NauJava.repository.TaskRepository;
import ru.gorodnichev_ilya.NauJava.repository.UserRepository;
import ru.gorodnichev_ilya.NauJava.repository.custom.TaskCriteriaRepository;

import java.util.List;
import java.util.UUID;

@SpringBootTest
@ActiveProfiles("test")
class TaskCriteriaRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void testFindByUserIdCriteria() {
        User user = new User();
        user.setLogin(UUID.randomUUID().toString());
        user.setEmail(UUID.randomUUID().toString());
        userRepository.save(user);

        Task task = new Task();
        task.setTaskName(UUID.randomUUID().toString());
        task.setUser(user);
        taskRepository.save(task);

        List<Task> tasks = taskRepository.findByUserIdCriteria(user.getUserID());

        Assertions.assertEquals(1, tasks.size());
        Assertions.assertEquals(task.getTaskID(), tasks.get(0).getTaskID());
    }

    @Test
    void testFindByCategoryNameCriteria() {
        Category category = new Category();
        category.setCategoryName(UUID.randomUUID().toString());
        categoryRepository.save(category);

        Task task = new Task();
        task.setTaskName(UUID.randomUUID().toString());
        task.setCategory(category);
        taskRepository.save(task);

        List<Task> tasks = taskRepository.findByCategoryNameCriteria(category.getCategoryName());

        Assertions.assertEquals(1, tasks.size());
        Assertions.assertEquals(task.getTaskID(), tasks.get(0).getTaskID());
    }
}

