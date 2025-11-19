package ru.gorodnichev_ilya.NauJava.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.gorodnichev_ilya.NauJava.domain.Task;
import ru.gorodnichev_ilya.NauJava.repository.custom.TaskCriteriaRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long>, TaskCriteriaRepository {

    @Query("SELECT t FROM Task t WHERE t.user.userID = :userId")
    List<Task> findByUserId(@Param("userId") Long userId);

    @Query("SELECT t FROM Task t WHERE t.category.categoryName = :name")
    List<Task> findByCategoryName(@Param("name") String name);
}
