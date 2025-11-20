package ru.gorodnichev_ilya.NauJava.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.gorodnichev_ilya.NauJava.domain.Recurrence;

@RepositoryRestResource
public interface RecurrenceRepository extends CrudRepository<Recurrence, Long> {
}
