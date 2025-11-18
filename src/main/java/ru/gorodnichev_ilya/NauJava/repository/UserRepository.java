package ru.gorodnichev_ilya.NauJava.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gorodnichev_ilya.NauJava.domain.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByLoginContainingOrEmailContaining(String loginPart, String emailPart);
}
