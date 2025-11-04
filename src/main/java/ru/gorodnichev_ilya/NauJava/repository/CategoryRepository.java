package ru.gorodnichev_ilya.NauJava.repository;

import org.springframework.data.repository.CrudRepository;
import ru.gorodnichev_ilya.NauJava.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
