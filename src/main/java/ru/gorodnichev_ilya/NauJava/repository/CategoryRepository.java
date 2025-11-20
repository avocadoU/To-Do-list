package ru.gorodnichev_ilya.NauJava.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.gorodnichev_ilya.NauJava.domain.Category;

@RepositoryRestResource
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
