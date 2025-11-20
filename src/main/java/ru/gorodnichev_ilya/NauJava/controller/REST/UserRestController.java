package ru.gorodnichev_ilya.NauJava.controller.REST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gorodnichev_ilya.NauJava.domain.User;
import ru.gorodnichev_ilya.NauJava.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class UserRestController {

    private final UserRepository userRepository;

    @Autowired
    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/search")
    public List<User> getByLoginContainingOrEmailContaining(@PathVariable String loginPart, @PathVariable String emailPart) {
        return userRepository.findByLoginContainingOrEmailContaining(loginPart, emailPart);
    }
}
