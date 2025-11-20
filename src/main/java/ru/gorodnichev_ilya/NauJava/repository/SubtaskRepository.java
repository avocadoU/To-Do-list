package ru.gorodnichev_ilya.NauJava.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.gorodnichev_ilya.NauJava.domain.Subtask;

@RepositoryRestResource
public interface SubtaskRepository extends CrudRepository<Subtask, Long> {
}
