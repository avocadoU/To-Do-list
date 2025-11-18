package ru.gorodnichev_ilya.NauJava.repository.custom;

import ru.gorodnichev_ilya.NauJava.domain.Task;

import java.util.List;

public interface TaskCriteriaRepository {

    List<Task> findByUserIdCriteria(Long userId);

    List<Task> findByCategoryNameCriteria(String categoryName);
}
