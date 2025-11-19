package ru.gorodnichev_ilya.NauJava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.gorodnichev_ilya.NauJava.domain.User;
import ru.gorodnichev_ilya.NauJava.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByLoginContainingOrEmailContaining() {
        User u1 = new User();
        u1.setLogin("ilya123");
        u1.setEmail("ilya@mail.com");
        userRepository.save(u1);

        User u2 = new User();
        u2.setLogin("admin");
        u2.setEmail("testuser@gmail.com");
        userRepository.save(u2);

        List<User> result = userRepository
                .findByLoginContainingOrEmailContaining("ly", "gmail");

        Assertions.assertEquals(2, result.size());
    }
}
