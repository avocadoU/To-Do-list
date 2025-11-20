package ru.gorodnichev_ilya.NauJava.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.gorodnichev_ilya.NauJava.domain.User;

import java.util.List;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByLoginContainingOrEmailContaining(String loginPart, String emailPart);
}
