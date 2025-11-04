package ru.gorodnichev_ilya.NauJava.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gorodnichev_ilya.NauJava.domain.Subtask;

public interface SubtaskRepository extends CrudRepository<Subtask, Long> {
}
