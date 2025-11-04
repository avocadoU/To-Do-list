package ru.gorodnichev_ilya.NauJava.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gorodnichev_ilya.NauJava.domain.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {

}
